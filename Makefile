.PHONY: build run jar clean

build:
	gradle build

run:
	gradle run

jar:
	gradle shadowJar

clean:
	gradle clean
