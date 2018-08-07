import CONF from '../Config'

export default {
  isloading: false,
  board: {seq: 0, title: '', content: '', reguser: '', updateuser: ''},
  boardlist: {
    pageno: 1, pagesize: CONF.PAGESIZE, totalcount: 0, list: []
  }
}
