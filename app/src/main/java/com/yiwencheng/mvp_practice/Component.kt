package com.yiwencheng.mvp_practice

import dagger.Component

@Component(modules = arrayOf(Module::class))
interface Component {
    fun inject(presenter: MainPresenter)
}