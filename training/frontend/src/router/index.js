import Vue from 'vue'
import Router from 'vue-router'
import BoardList from '@/components/Board/List.vue'
import BoardForm from '@/components/Board/Form.vue'
import NotFound from '@/components/NotFound.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/board/list'
    },
    {
      path: '/board/list',
      name: 'boardlist',
      component: BoardList,
      children: [
          {path: 'add', name: 'addboard', component: BoardForm}
      ]
    },
    {
      path: '*', component: NotFound
    }
  ]
})
