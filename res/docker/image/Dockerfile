FROM postgres:latest

COPY . /mydata

WORKDIR /mydata

EXPOSE 5432

ADD ./sql/hospital_db.sql /docker-entrypoint-initdb.d