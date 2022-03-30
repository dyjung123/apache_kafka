
# 概要
Zookeeperと Apache Kafkaを Docker containerとして実行する

## Zookeeperを Docker containerとして実行するCommand
```shell
docker run --name zookeeper -p 2181:2181 zookeeper
```

## Apache kafkaを Docker containerとして実行するCommand
```shell
docker run --name kafka -p 9092:9092 
-e KAFKA_ZOOKEEPER_CONNECT=localhost:2181 
-e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 
-e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 confluentinc/cp-kafka
```

## kafka 環境変数
- KAFKA_ADVERTISED_LISTENERS : kafka brokerを指す使用可能アドレス一蘭. kafkaは初期接続時これをclientに伝える
- KAFKA_LISTENERS : kafka brokerが来る接続を受信待機するアドレス及びlistener名一蘭
- KAFKA_ZOOKEEPER_CONNECT : ZooKeeper接続文字列. ,(comma)で区分
  - ex) <zookeeperサーバーの hostname>:<zookeeperサーバーのポート番号>
- KAFKA_CREATE_TOPICS : 作るTopic名:Partition数:Replica数
- KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR : topic partitionのコピー数である。値が1の場合 leader brokerにだけ partitionが記録される. この値は broker数より多ければいけない。

# 参考
https://miiingo.tistory.com/196 \
https://blog.naver.com/PostView.naver?blogId=sqlpro&logNo=222457487274&parentCategoryNo=7&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView
