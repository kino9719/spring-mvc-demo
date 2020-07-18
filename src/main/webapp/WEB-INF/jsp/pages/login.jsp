<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="app">
    <form class="uk-form-horizontal uk-margin-large">
        <fieldset class="uk-fieldset">
            <legend class="uk-legend">Login</legend>
            <div class="uk-margin">
                <label class="uk-form-label" for="form-horizontal-text">帳號</label>
                <div class="uk-form-controls">
                    <input class="uk-input" id="form-horizontal-text" type="text" placeholder="username" v-model="username">
                </div>
            </div>
            <div class="uk-margin">
                <label class="uk-form-label" for="form-horizontal-text">密碼</label>
                <div class="uk-form-controls">
                    <input class="uk-input" id="form-horizontal-text" type="password" placeholder="password" v-model="password">
                </div>
            </div>
            <button class="uk-button uk-button-primary" type="button" @click="login()">登入</button>
        </fieldset>
    </form>
</div>

<script src="/js/pages/login-app.js"></script>
