# 概要
簡単にdocker-composeで kafkaを構成して下記の3つを試してみる
1. topic生成
2. producer : 生成した topicにメッセージを書く
3. consumer : 生成した topicからメッセージを読んで表示する

# 事前作業
```shell
docker-compose -f docker-compose.yml up -d 
```

下記のリンクから ```kafka_2.13-2.7.2.tgz```をダウンロード

https://kafka.apache.org/downloads

下記の commandを実行してダウンロードした ファイルを解除する。\
その後、簡単にtopicのリスト確認（空でしょうけど）
```shell
tar xzvf kafka_2.13-2.7.2.tgz && cd kafka_2.13-2.7.2
bin/kafka-topics.sh --zookeeper localhost:2181 --list
```

# Topic生成
```shell
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic mytopic
```

## options
- zookeeper : zookeeperが実行中の host
- create : topic 生成要請
- replication-factor : 各 partitionのコピー本の数。デフォルト値は1であり、Cluster内 broker数を超過してはいけない
- partitions : topicを何個 partitionに分割するかという値
- topic : 生成する topic名

## 生成後結果確認
topic listを出力すると追加した mytopicが表示される
```shell
bin/kafka-topics.sh --zookeeper localhost:2181 --list
> mytopic
```

# Kafka Producer 実行 - Topicにメッセージ生成
```shell
$ bin/kafka-console-producer.sh --broker-list localhost:9092 --topic mytopic
> メッセージ入力する
```

# Kafka Consumer 実行 - メッセージを読んで表示
```shell
$ bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic mytopic --from-beginning
> Producerで入力してメッセージが表示される
```

# 参考
https://blog.naver.com/PostView.naver?blogId=sqlpro&logNo=222457487274&parentCategoryNo=7&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView
