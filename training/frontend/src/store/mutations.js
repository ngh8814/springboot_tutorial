import Constant from '../Constant'

export default {
  [Constant.LIST_BOARD]: (state, payload) => {
    state.boardlist = payload.boardlist
  },
  [Constant.VIEW_BOARD]: (state, payload) => {
    state.board = payload.board
  },
  [Constant.INIT_VIEW_BOARD]: (state, payload) => {
    state.board = {seq: 0, title: '', content: '', reguser: '', updateuser: ''}
  },
  [Constant.CHANGE_ISLOADING]: (state, payload) => {
    state.isloading = payload.isloading
  }
}
