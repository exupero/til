# Locking on an object

As a hobby Clojurist, I've never really needed much by way of concurrency management, mostly just running threads in the background without blocking my REPL.
Today, however, I wanted to read both stdout and stderr from a command and process results in the order the arrived.
To do so, I ran two `future`s:

```clojure
(let [{:keys [out err]} (babashka.process/process ...)]
  (with-open [out-rdr (io/reader out)
              err-rdr (io/reader err)]
    (future
      (loop []
        (when-let [line (.readLine out-rdr)]
          (println line)
          (recur))))
    (future
      (loop []
        (when-let [line (.readLine err-rdr)]
          (println line)
          (recur))))
    @(promise)))
```

Naturally the concurrent `println`s interfere with each other and mix their output on any given line.
The simplest solution was to use a core macro I've never needed before: [`locking`](https://clojuredocs.org/clojure.core/locking):

```clojure
(let [print-lock (Object.)
      {:keys [out err]} (babashka.process/process ...)]
  (with-open [out-rdr (io/reader out)
              err-rdr (io/reader err)]
    (future
      (loop []
        (when-let [line (.readLine out-rdr)]
          (locking print-lock
            (println line))
          (recur))))
    (future
      (loop []
        (when-let [line (.readLine err-rdr)]
          (locking print-lock
            (println line))
          (recur))))
    @(promise)))
```

Now each `println` waits if something another line is currently being printed.

An LLM also suggested using an agent to coordinate writes, but I've never needed agents either, so I'm not sure if they would be more idiomatic here.
I don't have any state for an agent to track, so using one would be mostly about coordinating locks, and `locking` describes that intent without additional confusion.
