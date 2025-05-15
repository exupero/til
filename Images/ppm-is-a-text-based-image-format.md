# PPM is a text-based image format

I've been converting [my blog](https://blog.exupero.org/) to build with Babashka scripts rather than a Clojure process, but for one post I generated a PNG using `java.awt.image.BufferedImage` and `javax.imageio.ImageIO`,  which Babashka doesn't include.
As a substitute, ChatGPT suggested generating a PPM file.
PPM is a [text-based image format](https://paulbourke.net/dataformats/ppm/), and ImageMagick is able to convert it to PNG.
The only trouble I ran into was that PPM files must end with a newline.
