<template>
    <div class="container">
        <search></search>
        <br>
        <div class="row">
            <div class="col-lg-12">
                <table id="list" class="table">
                    <thead>
                        <tr>
                            <th>Title</th>
                            <th>Content</th>
                            <th>RegUser</th>
                            <th>RegDatetime</th>
                            <th>UpdateUser</th>
                            <th>UpdateDatetime</th>
                            <th>Edit/Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="board in boardlist.list">
                            <td>{{board.title}}</td>
                            <td>{{board.content}}</td>
                            <td>{{board.reguser}}</td>
                            <td>{{board.regdatetime}}</td>
                            <td>{{board.updateuser}}</td>
                            <td>{{board.updatedatetime}}</td>
                            <td>
                                <button type="button" class="btn btn-primary btn-xs">수정</button>
                                <button type="button" class="btn btn-danger btn-xs">삭제</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <paginate ref="pagebuttons"
            :page-count="totalpage"
            :page-range="7"
            :margin-pages="3"
            :click-handler="pageChanged"
            :prev-text="'이전'"
            :next-text="'다음'"
            :container-class="'pagination'"
            :page-class="'page-item'">
        </paginate>
        <router-view></router-view>
        <div class="row">
            <router-link type="button" class="btn btn-primary btn-block" :to="{name: 'addboard'}">등록</router-link>
        </div>
    </div>
</template>
<script>
import Constant from '../../Constant.js'
import {mapState} from 'vuex'
import Paginate from 'vuejs-paginate'
import _ from 'lodash'
import Search from './Search'

export default {
    name: 'boardList',
    components: {Paginate, Search},
    computed: _.extend(
        {
            totalpage() {
                let totalcount = this.boardlist.totalcount;
                let pagesize = this.boardlist.pagesize;
                return Math.floor((totalcount - 1) / pagesize) + 1;
            }
        },
        mapState(['boardlist'])
    ),
    mounted: function() {
        let page = 1;
        if (this.$route.query && this.$route.query.page) {
            page = parseInt(this.$route.query.page)
        }
        this.$store.dispatch(Constant.LIST_BOARD, {pageno: page});
    },
    watch: {
        '$route': function(to, from) {
            console.log('watch');
            console.log(to.query.page);
            console.log(this.boardlist.pageno);
            if (to.query.page && to.query.page != this.boardlist.pageno) {
                let page = to.query.page;
                let title = to.query.title;


                console.log(page);
                this.$store.dispatch(Constant.LIST_BOARD, {pageno: page, title: title});
                this.$refs.pagebuttons.selected = page - 1;
            }
        }
    },
    methods: {
        pageChanged(page) {
            console.log('pageChanged');
            console.log(page);
            this.$router.push({name: 'boardlist', query: {page: page}})
        }
    }
}
</script>

<style scoped>
    #list th {text-align: center}
</style>
