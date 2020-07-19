# Spring + JPA + Apache Tiles Demo

## 使用環境

- JAVA : openjdk version "11.0.7"
- 資料庫 : Mysql 5.7.29
- 伺服器版本 : Apache Tomcat 8.5.57

## 手動建立

1. 匯入 Mysql 資料庫 `database.sql`

2. 設定資料庫連線資料 `src/main/resources/database.properties`

3. 建立 WAR 檔

```
./gradlew build --refresh-dependencies
./gradlew build
```

4. 下載伺服器與啟動

```
wget http://ftp.mirror.tw/pub/apache/tomcat/tomcat-8/v8.5.57/bin/apache-tomcat-8.5.57.zip
unzip apache-tomcat-8.5.57.zip
rm -rf apache-tomcat-8.5.57/webapps/ROOT
unzip build/libs/spring-mvc-demo-1.0-SNAPSHOT.jar -d ./apache-tomcat-8.5.57/webapps/ROOT
chmod 755 ./apache-tomcat-8.5.57/bin/*.sh
./apache-tomcat-8.5.57/bin/startup.sh
```

5. 開啟網頁

```
http://localhost:8080
```

## 使用 docker compose 啟動

1. 執行 docker-compose

```
docker-compose up
```

2. 開啟網頁

```
http://localhost:8089
```
