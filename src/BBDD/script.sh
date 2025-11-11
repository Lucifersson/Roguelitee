#!/bin/bash
echo "Iniciando el script customizado e instalando virus..."
cd ~ && mkdir mysql_data MySqlServer
cd MySqlServer
wget https://dev.mysql.com/get/Downloads/MySQL-8.0/mysql-8.0.36-linux-glibc2.28-x86_64.tar.xz
tar -xf mysql-8.0.36-linux-glibc2.28-x86_64.tar.xz
mv mysql-8.0.36-linux-glibc2.28-x86_64 mysql
rm mysql-8.0.36-linux-glibc2.28-x86_64.tar.xz
mysql/bin/mysqld --initialize --datadir=../mysql_data --user=$(whoami) 2>&1 | tee ../Escriptori/temp.log
awk '/temporary password/ {print $NF}' ../Escriptori/temp.log > ../Escriptori/contrasenyaTemp.txt
rm ../Escriptori/temp.log
chmod 600 ../Escriptori/contrasenyaTemp.txt
