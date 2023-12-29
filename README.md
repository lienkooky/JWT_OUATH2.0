# JWT_OUATH2.0
building JWT_OUATH2.0

</br>

------
</br>

## 23.12.29 <br> How to docker install

1. docker download
- docker pull [ want to download sql ]:[ version(options) ]

2. check docker
- docker images

3. docker run
- docker run --name mysql-container -e [ sql ]_ROOT_PASSWORD=[ password ] -d -p [ port:port ] [ sql ]:[ version ]

4. check docker list
- docker ps -a

5. start docker
- docker start [ sql ]-container

6. stop docker
- docker stop [ sql ]-container

7. restart docker
- docker restart [ sql ]-container

8. access container
- docker exec -it [ sql ]-container bash
