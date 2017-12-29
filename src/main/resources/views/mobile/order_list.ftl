<#include "./header.ftl" />
    <!-- Bootstrap -->
    <style type="text/css">
        .container {
            padding-top: 0;
        }
        .btn-wrap{
            width: 100%;
            padding: 10px 20px;
            display: flex;
            flex-direction: row;
            justify-content: center;
        }
        .order-day {
            border: 1px solid #ffb700;
            width: 33%;
        }
        .pull-box {
            padding: 10px 10px;
            border-radius: 6px;
            border:1px solid #ccc;
            background-color: #eee;
        }
        .order-list {
            margin: 0;
            padding: 0;
        }
        .order-li {
            margin-top: 10px;
            list-style: none;
            border:1px solid #ccc;
            background-color: #fff;
        }

        .order-li-text {
            padding: 8px;
            margin: 0;
        }

        .order-li-date {
            border-bottom: 1px solid #ffb700;
        }

        .order-li-content {
            color: #666;
            font-size: 13px;
            font-weight: bold;
        }

        .order-number {
            float: right;
        }

        .order-price {
            font-size: 16px;
            float: right;
        }

        .head-title {
            font-size: 24px;
            margin: 0;
            padding: 6px;
        }

        a.btn.router-link-active {
            border: 1px solid #ffb700;
            background-color: #ffb700;
            color: #fff;
        }

    </style>
</head>
<body>
<div class="container">
    <div class="btn-group btn-wrap" role="group">
        <router-link tag="div" to="/today" class="btn btn-default order-day">今天</router-link>
        <router-link tag="div" to="/yesterday" class="btn btn-default order-day">昨天</router-link>
        <router-link tag="div" to="/beforeYesterday" class="btn btn-default order-day">前天</router-link>
    </div>
    <div class="pull-box">
        <router-view></router-view>
    </div>
</div>
<!-- docs : https://github.com/lakb248/vue-pull-refresh -->
<script src="${app.siteUrl}/js/vue-pull-refresh.min.js"></script>
<script type="text/javascript">

    function dayStart(date) {
        date.setHours(0)
        date.setMinutes(0)
        date.setSeconds(0)
        date.setMilliseconds(0)
        return date
    }

    function dayEnd(date) {
        date.setHours(23)
        date.setMinutes(59)
        date.setSeconds(59)
        date.setMilliseconds(0)
        return date
    }

    function getToday() {
        var date = new Date()
        return date
    }

    function getYesterday() {
        var date = new Date()
        date.setDate(date.getDate() - 1)
        return date
    }

    function getAfterYesterday() {
        var date = new Date()
        date.setDate(date.getDate() - 2)
        return date
    }

    function jooqResultToArray(result) {
        var fields = result.fields
        var records = result.records
        return records.map(function (record) {
            var obj = {}
            record.forEach(function (val, i) {
                obj[fields[i].name] = val
            })
            return obj
        })
    }

    var OrderListComponent = {
        components: {
            'vue-pull-refresh': VuePullRefresh
        },
        data : function () {
            return {
                orders: [1, 2, 3, 4, 5, 5, 6, 7, 8, 8],
                pageNum: 1,
                isRefreshing: false
            }
        },
        methods: {
            fetchByTime: function (startTime, endTime) {
                var self = this
                return new $.ajax('/orders?startDate='+ startTime.valueOf() +'&endDate='+ endTime.valueOf() +'&pageNum=' + self.pageNum).then(function (_orders) {
                    self.orders = jooqResultToArray(_orders).concat(self.orders)
                    self.isRefreshing = false
                    self.pageNum++
                });
            },
            onRefresh: function () {
                var self = this
                if ( !self.isRefreshing ) {
                    self.isRefreshing = true
                    var meta = self.$route.matched[0].meta
                    return self.fetchByTime(meta.startDate, meta.endDate)
                }
                return Promise.resolve()
            }
        },
        template: '<vue-pull-refresh :on-refresh.prevent="onRefresh">' +
                '<ul class="order-list">' +
                    '<li class="order-li" v-for="order in orders">' +
                        '<h4 class="head-title"># 1</h4>' +
                        '<p class="order-li-text order-li-date">09月19号 23:24 <span class="order-number">20170919100011611</span></p>' +
                        '<p class="order-li-text order-li-content">测试订单 *1<br>测试订单 *1<br>茶树菇老鸭套餐 *1<span class="order-price">总计：¥10.00</span></p>' +
                    '</li>' +
                '</ul>' +
        '</vue-pull-refresh>'
    }
    var router = new VueRouter({
        mode: 'hash',
        routes: [
            { path: '/', redirect: '/today' },
            { path: '/today', component: OrderListComponent, meta: { startDate: dayStart(getToday()), endDate: dayEnd(getToday()) } },
            { path: '/yesterday', component: OrderListComponent, meta: { startDate: dayStart(getYesterday()), endDate: dayEnd(getYesterday()) } },
            { path: '/beforeYesterday', component: OrderListComponent, meta: { startDate: dayStart(getAfterYesterday()), endDate: dayEnd(getAfterYesterday()) } }
        ]
    })
    var vue = new Vue({
        router: router
    })
    vue.$mount(".container")
</script>

<#include "./footer.ftl" />