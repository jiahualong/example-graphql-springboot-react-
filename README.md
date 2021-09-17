# Graphql 实例

Graphql请求示例.

前端使用react.js, 后端使用 graphql-springboot-start.

|项目|描述|
|:--- |:--- |
| graphql-react-app     | react 17.0.2<br/> graphql 15.5.3 |
| graphql-springboot-app| java 11 <br /> graphql-spring-boot-starter:1.0.0-SNAPSHOT |

# 接口

## 查询所有games接口

请求

```graphql
query {
    games {
        id
        name
        imgUrl
    }
}
```

返回

```json
{
  "data": {
    "games": [
      {
        "id": "a",
        "name": "DarkSouls",
        "imgUrl": "https://image.api.playstation.com/trophy/np/NPWR13281_00_00A03E8F7ED2727FADE2548E45F2781D32F5D048F6/B26EE8644603C33DBEB01C4E172FB4972D069B2E.PNG"
      },
      {
        "id": "b",
        "name": "Sekiro",
        "imgUrl": "https://image.api.playstation.com/trophy/np/NPWR15587_00_00B683E5453204A612C38DC218AEF0317CD5E8E9CC/85B017F39EA939B035F2C5A6B7198E87DAC9B610.PNG"
      },
      {
        "id": "c",
        "name": "GuiltyGear",
        "imgUrl": "https://image.api.playstation.com/trophy/np/NPWR10126_00_00B71A99A02F0CBA06FD43F769BD6779B115B44825/2271ABD0BB48D27B8557943FDEA2C2AC4C58470A.PNG"
      },
      {
        "id": "d",
        "name": "GodOfWar",
        "imgUrl": "https://image.api.playstation.com/trophy/np/NPWR12518_00_009C1232E900005FE409857E926767DFE9CAC7F371/CCDC60CADE4B3970C348FEFDE0094BA95C0A802F.PNG"
      },
      {
        "id": "e",
        "name": "eGame",
        "imgUrl": "imgurl"
      },
      {
        "id": "e",
        "name": "eGame",
        "imgUrl": "imgurl"
      }
    ]
  }
}
```

## 通过id查Game

请求

```graphql
query {
    queryGameById(id: "a") {
        id
        name
        imgUrl
    }
}
```

返回

```json
{
  "data": {
    "queryGameById": {
      "id": "a",
      "name": "DarkSouls",
      "imgUrl": "https://image.api.playstation.com/trophy/np/NPWR13281_00_00A03E8F7ED2727FADE2548E45F2781D32F5D048F6/B26EE8644603C33DBEB01C4E172FB4972D069B2E.PNG"
    }
  }
}
```

## 通过id查Games的另一种写法

```graphql
query queryGameById($id: String!){
    queryGameById(id: $id) {
        id
        name
        imgUrl
    }
}
```

需要在变量区为 $id 赋值

## 添加一个Game对象

```graphql
mutation {
    createGame(input: {id: "e", name:"eGame", imgUrl: "imgurl"}) {
        id
        name
        imgUrl
    }
}
```

返回
```json
{
  "data": {
    "createGame": {
      "id": "e",
      "name": "eGame",
      "imgUrl": "imgurl"
    }
  }
}
```

# 引用

* [apollographql](https://www.apollographql.com/docs/react/data/mutations/)

