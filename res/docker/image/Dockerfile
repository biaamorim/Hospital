FROM mysql:latest

COPY . /mydb

WORKDIR /mydb

EXPOSE 3306

ADD ./sql/hospital_db.sql /docker-entrypoint-initdb.d