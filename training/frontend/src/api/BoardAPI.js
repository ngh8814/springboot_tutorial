import CONF from '../Config'
import axios from 'axios'

export default {
  list (title, pageno, pagesize) {
    return axios.get(CONF.LIST, {
      params: {
        title: title,
        pageno: pageno,
        pagesize: pagesize
      }
    })
  },
  add (board) {
    return axios.post(CONF.ADD, board);
  },


}
