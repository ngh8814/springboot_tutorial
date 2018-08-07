let BASE_URL = '/api'

export default {
  PAGESIZE: 10,
  LIST: BASE_URL + '/board/list',
  ADD: BASE_URL + '/board/add',
  EDIT: BASE_URL + '/board/edit',
  VIEW: BASE_URL + '/board/view/${id}',
  DELETE: BASE_URL + '/board/delete/${id}'
}
