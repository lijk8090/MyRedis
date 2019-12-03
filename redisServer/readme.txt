tar xvf redis-4.0.14.tar.gz
cd redis-4.0.14/src/

make
make install

\cp -rf ../redis.conf /usr/local/etc/

/usr/local/bin/redis-server /usr/local/etc/redis.conf
/usr/local/bin/redis-cli -h 127.0.0.1 -p 6379
