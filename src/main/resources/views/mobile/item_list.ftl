<#include "./header.ftl" />
<#setting number_format="000">

<link rel="stylesheet" type="text/css" href="${app.siteUrl}/css/lianxi-2.css">
</head>
<body>

<div class="container wrap" id="container">
    <div class="list-group-item yth-list-group-one">
        <a href="/items/new" class="btn btn-default btn-block">+ 添加商品</a>
    </div>
    <div id="page-content">
        <router-view></router-view>
    </div>
</div>
<script>
    function dataProcess(list) {
        return list.map( function (item) {
            if ( item.thumbnails != null && item.thumbnails.length > 0 ) {
                item.thumbnail = item.thumbnails.split(':')[0]
            }
            return item
        })
    }
    var MainComponent = {
        template: '<div><div class="yth-nav-list" id="yth-item-list">\n' +
        '            <ul class="category-list nav nav-pills nav-stacked yth-nav-stacked">\n' +
        '                <li v-for="cate in categories" :key="cate.id" :class="{ active: currentCateId === cate.id }" role="presentation"><router-link :to=\'{ path: \"/\", query: { \"cateId\": cate.id } }\' class="nav-link">{{cate.categoryName}}</router-link></li>\n'+
        '            </ul>\n' +
        '            <ul class="list-group list-wrap list item-list">\n' +
        '                <li v-for="item in itemList" :key="item.id" class="list-group-item yth-list-group">\n'+
        '                    <div class="media">\n'+
        '                        <div class="media-left media-middle">\n'+
        '                            <img class="media-object img-rounded item-image" :src="item.thumbnail | thumbnailUrl(\'item\')" :alt="item.itemName">\n'+
        '                        </div>\n'+
        '                        <div class="media-body">\n'+
        '                            <h5 class="media-heading">{{item.itemName}}</h5>\n'+
        '                            <p>{{item.itemDesc}}</p>\n'+
        '                            <p><span class="discounted-price">¥{{item.discountPrice / 100}}</span><s class="original-price">¥{{item.productPrice / 100}}</s></p>\n'+
        '                        </div>\n'+
        '                        <div class="media-right media-middle">\n'+
        '                            <a :href="item.id | fullUrl(\'/items/\')" class="btn btn-link">编辑</a>\n'+
        '                        </div>\n'+
        '                    </div>\n'+
        '                </li>\n'+
        '                <li v-if="itemList.length < 1">空空如也</li>\n' +
        '            </ul>\n' +
        '        </div>\n' +
        '        <a @click="onLoadMore" class="refresh">加载更多</a>' +
                '</div>',
        data: function () {
            return {
                siteUrl: siteUrl,
                categories: [],
                itemList: [],
                pageNum: 1,
                currentCateId: 0
            }
        },
        watch: {
            '$route': 'fetchItems'
        },
        created: function () {
            this.fetchCategory()
            this.fetchItems()
        },
        filters: {
            fullUrl: function (val, contextPath) {
                return this.siteUrl + contextPath + val
            },
            thumbnailUrl: function (url, type) {
                if (type === 'item') {
                    if (url) {
                        return cdnUrl + '/' + url
                    } else {
                        return cdnUrl + '/default_image_item.jpg'
                    }
                }
                if (type === 'category') {
                    return cdnUrl + '/' + url
                }
            }
        },
        methods: {
            fetchCategory: function () {
                var self = this;
                $.ajax("/categories/").success(function(res) {
                    self.categories = res.data;
                })
            },
            fetchItems: function () {
                var self = this;
                $.ajax("/items/?pageNum=1" + getCateIdQuery(self.$route)).success(function(res) {
                    self.itemList = dataProcess( res.data );
                    self.pageNum = 1;
                    self.pageNum++;
                    self.currentCateId = res.meta.extra.cateId
                    sessionStorage.setItem('item_list.cateId', self.currentCateId)
                })
            },
            onLoadMore: function () {
                var self = this;
                this.pageNum++;
                $.ajax("/items/?pageNum=" + this.pageNum + getCateIdQuery(self.$route)).success(function(res) {
                    self.itemList = self.itemList.concat( dataProcess( res.data ) );
                    // default pageSize 30
                    if ( self.itemList.length < 30 ) {
                        self.pageNum--;
                        $.toast({
                            heading: '没有更多了...',
                            text: '已经没有更多数据额',
                            showHideTransition: 'slide',
                            icon: 'warning',
                            hideAfter: 1000
                        });
                    }
                })
            }
        }
    }

    function getCateIdQuery($route) {
        return $route.query.cateId ? '&cateId=' + $route.query.cateId : ''
    }

    var router = new VueRouter({
        mode: 'hash',
        routes: [
            { path: '/', component: MainComponent }
        ]
    })

    var list = new Vue({
        el: '#page-content',
        router: router
    })

</script>

<#include "./footer.ftl" />