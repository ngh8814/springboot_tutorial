<template lang="html">
  <div class="modal">
      <div class="modal-dialog">
          <div class="modal-content">
              <div class="modal-header">
                  <h5 class="modal-title">{{headingText}}</h5>
                  <button type="button" class="close"><span>&times;</span></button>
              </div>
              <div class="modal-body">
                  <div class="form-group" v-if="mode == 'update'">
                      <label for="">ID</label>
                      <input type="text" name="seq" class="form-control" readonly v-model="board.seq">
                  </div>
                  <div class="form-group">
                      <label for="">제목</label>
                      <input type="text" name="title" class="form-control" v-model="board.title" placeholder="제목을 입력하세요.">
                  </div>
                  <div class="form-group">
                      <label for="">내용</label>
                      <textarea name="content" class="form-control" v-model="board.content" placeholder="내용을 입력하세요."></textarea>
                  </div>
                  <div class="form-group">
                      <label for="">등록자</label>
                      <input type="text" name="reguser" class="form-control" v-model="board.reguser" placeholder="등록자를 입력하세요.">
                  </div>
                  <div class="form-group" v-if="mode == 'update'">
                      <label for="">수정자</label>
                      <input type="text" name="updateuser" class="form-control" v-model="board.updateuser" placeholder="수정자를 입력하세요.">
                  </div>
              </div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" @click="cancelEvent()">닫기</button>
                  <button type="button" class="btn btn-primary" @click="submitEvent()">{{btnText}}</button>
              </div>
          </div>
      </div>
  </div>
</template>

<script>
import Constant from '../../Constant'
import {mapState} from 'vuex'
import _ from 'lodash'

export default {
    name: 'boardForm',
    data: function() {
        return {mode: 'add'}
    },
    props: ['seq'],
    computed: _.extend(
        {
            btnText() {
                if (this.mode != 'update') {
                    return '등록';
                } else {
                    return '수정';
                }
            },
            headingText() {
                if (this.mode != 'update') {
                    return "게시판 신규 등록"
                }
            }
        },
        mapState(['board', 'boardlist'])
    ),
    mounted: function() {
        let cr = this.$router.currentRoute;

        if (cr.fullPath.indexOf('/add') > -1) {
            this.mode = 'add';
            this.$store.dispatch(Constant.INIT_VIEW_BOARD);
        } else if (cr.fullPath.indexOf('/edit') > -1) {
            this.mode = 'edit';
            this.$store.dispatch(Constant.VIEW_BOARD, {seq: this.seq});
        }
    },
    methods: {
        submitEvent() {
            if (this.mode == 'edit') {
                this.$store.dispatch(Constant.EDIT_BOARD);
                this.$router.push({name: 'boardlist', query: {page: this.boardlist.pageno}});
            } else {
                this.$store.dispatch(Constant.ADD_BOARD);
                this.$router.push({name: 'boardlist', query: {page: 1}});
            }
        },
        cancelEvent() {
            this.$router.push({name: 'boardlist', query: {page: this.boardlist.pageno}});
        }
    }
}
</script>

<style scoped>
.modal {display: block; z-index: 1}
button.close {
    display: none;
}
</style>
