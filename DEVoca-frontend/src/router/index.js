import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '@/views/LoginView.vue'
import SignupView from '@/views/SignupView.vue'
import SelectInterestsView from '@/views/SelectInterestsView.vue'
import MainView from '@/views/feeds/MainView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    // user
    {
      path: '/login',
      name: 'LoginView',
      component: LoginView
    },
    {
      path:'/signup',
      name:'SigupView',
      component : SignupView
    },
    {
      path: '/selectinterests',
      name: 'SelectInterestsView',
      component : SelectInterestsView
    },
    // feed
    {
      path: '/',
      name: 'MainView',
      component: MainView
    },
  ]
})

export default router
