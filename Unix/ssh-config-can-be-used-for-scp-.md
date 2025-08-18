# SSH config can be used for `scp`

Given an SSH config file like this:

```
Host myserver
    HostName 192.168.1.1
    Port 8888
    User myusername
    IdentityFile ~/.ssh/id_rsa
```

You can `scp` using the same config just by naming the host, avoiding the need to specify a username, IP address, port, etc.:

```
scp some-file.txt myserver:~/server-file.txt
```
