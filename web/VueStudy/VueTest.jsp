<%--
  Created by IntelliJ IDEA.
  User: DYK
  Date: 2020/3/19
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="vue.js"></script>
</head>
<body>
<div id="app">
    <h3>{{msg}}</h3>
    <!--    v-bind只能实现数据的单项绑定-->
    <!--    <input type="text" v-bind:value="msg">-->
    <!--    数据的双向绑定只能用v-model-->
    <input type="text" v-model="msg" style="width: 100%">
</div>

<script>

    var vm = new Vue({
        el:'#app',
        data: {
            msg:'你好，一定要加油，不然就会失业'
        },
        methods:{

        }
    });
</script>
</body>
</html>
