# Hair Salon

##### Epicodus exercise using Java and Postgres, 01.21.2016

##### Author
Charles Carter

## Description
This is an app for Chuck's Shears, a hair salon app that uses databases to create a one-to-many relationship between stylists and their clients.

## Setup

Clone this repository:
```
$ cd ~/Desktop
$ git clone https://github.com/charcar/java-salon.git
$ cd java-salon
```

Open terminal and run Postgres:
```
$ postgres
```

Open a new tab in terminal and create the `hair_salon` database:
```
$ psql
$ CREATE DATABASE hair_salon;
$ psql hair_salon < hair_salon.sql
```

Navigate back to the directory where this repository has been cloned and run gradle:
```
$ gradle run
```

## Technologies Used

Java, Sql, Spark, Junit, html, css


## Legal

Copyright (c) 2016 Charles Carter

This software is licensed under the MIT license.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
