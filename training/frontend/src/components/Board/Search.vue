<template>
    <div class="row">
        <div class="col-lg-12">
            <form>
                <div class="form-row">
                    <div class="col-auto">
                        <input type="text" class="form-control" v-model="title" placeholder="엔터를 누르면 검색됩니다." @keyup.enter="keyupEvent">
                    </div>
                </div>
            </form>
        </div>
    </div>
</template>
<script type="text/javascript">
    import Constant from '../../Constant'

    export default {
        name: 'search',
        data: function() {
            return {title: ''}
        },
        methods: {
            keyupEvent(e) {
                let val = e.target.value;
                let page = 1;
                //this.$store.dispatch(Constant.LIST_BOARD, {pageno: page, title: val});
                this.$router.push({name: 'boardlist', query: {page: page, title: val}})
            }
        }
    }
</script>
