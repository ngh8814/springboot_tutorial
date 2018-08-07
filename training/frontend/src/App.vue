<template>
<div id="container">
  <div class="page-header">
    <h1 class="text-center">Board App</h1>
    <router-view></router-view>
    <loading v-show="isloading"></loading>
  </div>
</div>
</template>


<script>
import Loading from './components/Loading'
import {
  mapState
} from 'vuex'

export default {
  name: 'App',
  components: {
    Loading
  },
  computed: mapState(['isloading'])
}
</script>

<style>
@import url('https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.css');

#container {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
