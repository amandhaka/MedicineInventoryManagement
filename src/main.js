import Vue from 'vue'
// import VueRouter from 'vue-router'
// import Vuex from 'vuex'
import App from './App.vue'
import router from './router'
import store from './store'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
// changed

// Vue.use(VueRouter)
// Vue.use(Vuex)

Vue.config.productionTip = false

// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)

// changed
// const store = new Vuex.Store(
//   {
//       state: {
//           authenticated: false
//       },
//       mutations: {
//           setAuthentication(state, status) {
//               state.authenticated = status;
//           }
//       }
//   }
// );

// const router = new VueRouter({
//   routes: [
//     {
//       path: '/login-as-',
//       mane: '/login-as-',
//       component: homePage
//     },
//       {
//         path: '/admin',
//         name: 'admin',
//         component: admin,
//         beforeEnter: (to, from, next) => {
//           if (store.state.authenticated == false) {
//             next(false)
//           } else {
//             next()
//           }
//         }
//       }
//   ]
// });

new Vue({
  render: h => h(App),
  router: router,
  store
}).$mount('#app')
