import boardAPI from '../api/BoardAPI'
import Constant from '../Constant'

export default {
  [Constant.CHANGE_ISLOADING]: (store, payload) => {
    store.commit(Constant.CHANGE_ISLOADING, payload)
  },
  [Constant.LIST_BOARD]: (store, payload) => {
    let pageno
    if (typeof payload === 'undefined' || typeof payload.pageno === 'undefined') {
      pageno = 1
    } else {
      pageno = payload.pageno
    }

    let pagesize = store.state.boardlist.pagesize

    store.dispatch(Constant.CHANGE_ISLOADING, {isloading: true})

    boardAPI.list(payload.title, pageno, pagesize)
      .then((response) => {
          console.log(response.data);
        store.commit(Constant.LIST_BOARD, {boardlist: response.data})
        store.dispatch(Constant.CHANGE_ISLOADING, {isloading: false})
      })
  },
  [Constant.INIT_VIEW_BOARD]: (store) => {
      store.commit(Constant.INIT_VIEW_BOARD);
  },
  [Constant.ADD_BOARD]: (store) => {
      store.dispatch(Constant.CHANGE_ISLOADING, {isloading: true})
      boardAPI.add(store.state.board)
        .then((response) => {
            console.log(response);
            if (response.status === 200) {
                store.dispatch(Constant.LIST_BOARD, {pageno: 1})
            } else {
                alert('등록 실패하였습니다.');
                console.log(response.data);
            }
        })
  }

}
