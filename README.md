# pico-y-placa

## Prerequisites
This was tested for openjdk 1.8 and 1.11

## Building
```bash
mvn package
```

## Running the program
```bash
java -jar target/picoyplaca.jar {license-number} {yyyy-mm-dd} {hh:MM}
```
For example
```bash
java -jar target/picoyplaca.jar PBA0001 2021-08-02 08:00
```
