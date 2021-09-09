# MasterMind

* This project aims to find the correct code composed of 4 numbers.
* To test the solution you need JDK 11 & Maven 3.6, and if you prefer a quickstart use the docker image.

## Maven Run

* First build the package of the solution using Assembly

```sh
mvn clean pacakge
```

* You have two modes of Gameplay Easy and Hard.
* In the easy play you choose your secret code.
* If you don't choose your secret code, by default a secret code of 4 numbers is generated and this is the hard mode.

```sh
./target/tm-deploy/bin/play-game --secret-word $SECRET
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