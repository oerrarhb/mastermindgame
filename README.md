# MasterMind

* This project aims to find the correct code composed of 4 numbers.
* To test the solution you need JDK 11 & Maven 3.6, and if you prefer a quickstart use the docker image.

## Maven Run

* First build the package of the solution using Assembly

```sh
mvn clean package
```

* You have two modes of Gameplay Easy and Hard.
* In the easy play you choose your secret code.
* If you don't choose your secret code, by default a secret code of 4 numbers is generated and this is the hard mode.

```sh
./target/tm-deploy/bin/play-game --secret-word $SECRET
```

### Examples

* Easy mode

```sh
./target/tm-deploy/bin/play-game --secret-word 1234
```

* Hard mode

```sh
./target/tm-deploy/bin/play-game
```

## Docker Run

* Build the image

```sh
docker build -t $IMAGE_NAME:latest .
```

* RUN the image in a container

```sh
docker run -it $IMAGE_NAME --secret-word $SECRET
```

### Examples

* If the name of the image is `img`, the command bellow allows you to play the easy mode

```sh
docker run -it img --secret-word 1234
```

* If the name of the image is `img`, the command bellow allows you to play the hard mode

```sh
docker run -it img
```