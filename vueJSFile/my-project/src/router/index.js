import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import login from '@/components/login'
import studentList from '@/components/studentList'
import addStudent from '@/components/addStudent'
import updateStudent from '@/components/updateStudent'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'login',
      component: login

    },
    {
      path: '/studentList',
      name: 'Student List',
      component: studentList

    },
    {
      path: '/addStudent',
      name: 'Add Student',
      component: addStudent

    },
    {
      path: '/updateStudent/:id',
      name: 'Update Student',
      component: updateStudent,
      props: true

    }

  ]
})
