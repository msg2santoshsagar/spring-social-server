webpackJsonp(["main"],{

/***/ "../../../../../src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "../../../../../src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "../../../../../src/app/app.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<!--The content below is only a placeholder and can be replaced.-->\n<div style=\"text-align:center\">\n  <h1>\n    Welcome to {{ title }}!\n  </h1>\n</div>\n<router-outlet></router-outlet>"

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = (function () {
    function AppComponent() {
        this.title = 'Spring Social Application';
    }
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-root',
            template: __webpack_require__("../../../../../src/app/app.component.html"),
            styles: [__webpack_require__("../../../../../src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("../../../platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__login_form_login_form_component__ = __webpack_require__("../../../../../src/app/login-form/login-form.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__home_home_component__ = __webpack_require__("../../../../../src/app/home/home.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__page_not_found_page_not_found_component__ = __webpack_require__("../../../../../src/app/page-not-found/page-not-found.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};









var routes = [
    {
        "path": "",
        "component": __WEBPACK_IMPORTED_MODULE_6__login_form_login_form_component__["a" /* LoginFormComponent */],
        "pathMatch": "full"
    },
    {
        "path": "home",
        "component": __WEBPACK_IMPORTED_MODULE_7__home_home_component__["a" /* HomeComponent */]
    }, {
        "path": "**",
        "component": __WEBPACK_IMPORTED_MODULE_8__page_not_found_page_not_found_component__["a" /* PageNotFoundComponent */]
    }
];
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["I" /* NgModule */])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_6__login_form_login_form_component__["a" /* LoginFormComponent */],
                __WEBPACK_IMPORTED_MODULE_7__home_home_component__["a" /* HomeComponent */],
                __WEBPACK_IMPORTED_MODULE_8__page_not_found_page_not_found_component__["a" /* PageNotFoundComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_common_http__["b" /* HttpClientModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_forms__["a" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_3__angular_router__["b" /* RouterModule */].forRoot(routes)
            ],
            providers: [],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "../../../../../src/app/home/home.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/home/home.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n\n  <div class=\"col-md-12 mb-4\">\n    <p class=\"col-md-6 col-xs-6\">Home Page</p>\n    <button class=\"btn btn-primary btn-sm pull-right\" (click)=\"logout()\">LOG OUT</button>\n  </div>\n  <table class=\"table\">\n    <tr>\n      <td>User Id</td>\n      <td>{{user.userName}}</td>\n    </tr>\n    <tr>\n      <td>Name</td>\n      <td>{{user.name}}</td>\n    </tr>\n    <tr>\n      <td>Email</td>\n      <td>{{user.email}}</td>\n    </tr>\n    <tr>\n      <td>User Role</td>\n      <td>{{toStr(user.role)}}</td>\n    </tr>\n  </table>\n\n\n</div>"

/***/ }),

/***/ "../../../../../src/app/home/home.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HomeComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var HomeComponent = (function () {
    function HomeComponent(http, router) {
        this.http = http;
        this.router = router;
        this.user = {};
    }
    HomeComponent.prototype.ngOnInit = function () {
        var _this = this;
        var url = __WEBPACK_IMPORTED_MODULE_2__environments_environment__["a" /* environment */].apiAuth;
        console.log("AUTH URL :: ", url);
        this.http.post(url, null, {
            headers: new __WEBPACK_IMPORTED_MODULE_1__angular_common_http__["c" /* HttpHeaders */]({ 'Content-Type': 'application/json' }),
            withCredentials: true
        }).subscribe(function (data) {
            console.log("User is authorized");
            _this.user = data;
        }, function (err) {
            console.error("Error Occured while loading auth data :: ", err.error);
            _this.router.navigate(["/"]);
        });
    };
    HomeComponent.prototype.toStr = function (data) {
        if (data === undefined) {
            return "";
        }
        return data.map(function (a) { return a.name; }).join(", ");
    };
    HomeComponent.prototype.logout = function () {
        var _this = this;
        console.log("Request to logout");
        var url = __WEBPACK_IMPORTED_MODULE_2__environments_environment__["a" /* environment */].apiLogOut;
        this.http.post(url, null, {
            headers: new __WEBPACK_IMPORTED_MODULE_1__angular_common_http__["c" /* HttpHeaders */]({ 'Content-Type': 'application/json' }),
            withCredentials: true
        }).subscribe(function (data) {
            console.log("User is loggedout.");
            _this.user = {};
            _this.router.navigate(["/"]);
        }, function (err) {
            console.error("Error Occured while logging out :: ", err.error);
            _this.router.navigate(["/"]);
        });
    };
    HomeComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-home',
            template: __webpack_require__("../../../../../src/app/home/home.component.html"),
            styles: [__webpack_require__("../../../../../src/app/home/home.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_3__angular_router__["a" /* Router */]])
    ], HomeComponent);
    return HomeComponent;
}());



/***/ }),

/***/ "../../../../../src/app/login-form/login-form.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".form_bg {\r\n    background-color:#eee;\r\n    color:#666;\r\n    padding:20px;\r\n    border-radius:10px;\r\n    border:1px solid #fff;\r\n    margin: auto;\r\n    top: 0;\r\n    right: 0;\r\n    bottom: 0;\r\n    left: 0;\r\n    width: 320px;\r\n}\r\n.align-center {\r\n    text-align:center;\r\n}", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/login-form/login-form.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"container\">\n  <div class=\"row\">\n    <div class=\"form_bg\">\n\n      <div class=\"row\">\n\n        <div class=\"col-md-6 col-xs-6\">\n          <form action=\"{{apiSignIn.facebook}}\" method=\"post\" ngNoForm>\n            <input type=\"hidden\" name=\"scope\" value=\"email,public_profile\" />\n            <div class=\"form-group\">\n              <button type=\"submit\" class=\"btn btn-default btn-sm\" id=\"fb-login\">Facebook login</button>\n            </div>\n          </form>\n        </div>\n\n        <div class=\"col-md-6 col-xs-6\">\n          <form action=\"{{apiSignIn.twitter}}\" method=\"post\" ngNoForm>\n            <input type=\"hidden\" name=\"include_email\" value=\"true\" />\n            <div class=\"form-group\">\n              <button type=\"submit\" class=\"btn btn-default btn-sm\" id=\"twitter-login\">Twitter login</button>\n            </div>\n          </form>\n        </div>\n\n        <div class=\"col-md-6 col-xs-6\">\n          <form action=\"{{apiSignIn.linkedin}}\" method=\"post\" ngNoForm>\n            <div class=\"form-group\">\n              <button type=\"submit\" class=\"btn btn-default btn-sm\" id=\"linkedin-login\">Linkedin login</button>\n            </div>\n          </form>\n        </div>\n\n        <div class=\"col-md-6 col-xs-6\">\n          <form action=\"{{apiSignIn.google}}\" method=\"post\" ngNoForm>\n            <input type=\"hidden\" name=\"scope\" value=\"email\" />\n            <div class=\"form-group\">\n              <button type=\"submit\" class=\"btn btn-default btn-sm\" id=\"google-login\">Google login</button>\n            </div>\n          </form>\n\n        </div>\n\n      </div>\n\n      <div class=\"row\" *ngIf=\"loginErrorMessage != null\">\n        <div class=\"col-md-12\">\n            <div class=\"alert alert-danger\">\n                <strong>Error!</strong> {{loginErrorMessage}}\n              </div>\n        </div>\n      </div>\n\n      <form class=\"form-signin\" #loginForm=\"ngForm\" (ngSubmit)=\"login(loginForm)\">\n        <h2 class=\"text-center\">Login Page</h2>\n        <br/>\n        <div class=\"form-group\">\n          <input [(ngModel)]=\"user.username\" type=\"text\" class=\"form-control\" name=\"username\" id=\"username\" placeholder=\"User id\" autocomplete=\"off\" required>\n        </div>\n        <div class=\"form-group\">\n          <input [(ngModel)]=\"user.password\" type=\"password\" class=\"form-control\" name=\"password\" id=\"password\" placeholder=\"Password\" required>\n        </div>\n        <br/>\n        <div class=\"align-center\">\n          <button type=\"submit\" class=\"btn btn-default\" id=\"login\">Login</button>\n        </div>\n      </form>\n    </div>\n  </div>\n</div>"

/***/ }),

/***/ "../../../../../src/app/login-form/login-form.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LoginFormComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var LoginFormComponent = (function () {
    function LoginFormComponent(http, router) {
        this.http = http;
        this.router = router;
        this.user = {
            username: "",
            password: ""
        };
        this.apiSignIn = {
            facebook: __WEBPACK_IMPORTED_MODULE_2__environments_environment__["a" /* environment */].apiLoginFB,
            twitter: __WEBPACK_IMPORTED_MODULE_2__environments_environment__["a" /* environment */].apiLoginTwitter,
            linkedin: __WEBPACK_IMPORTED_MODULE_2__environments_environment__["a" /* environment */].apiLoginLinkedin,
            google: __WEBPACK_IMPORTED_MODULE_2__environments_environment__["a" /* environment */].apiLoginGoogle
        };
        this.loginErrorMessage = null;
    }
    LoginFormComponent.prototype.ngOnInit = function () {
        var _this = this;
        if (!__WEBPACK_IMPORTED_MODULE_2__environments_environment__["a" /* environment */].production) {
            this.user.username = "admin";
            this.user.password = "admin";
        }
        var url = __WEBPACK_IMPORTED_MODULE_2__environments_environment__["a" /* environment */].apiAuth;
        console.log("AUTH URL :: ", url);
        this.http.post(url, null, {
            headers: new __WEBPACK_IMPORTED_MODULE_1__angular_common_http__["c" /* HttpHeaders */]({ 'Content-Type': 'application/json' }),
            withCredentials: true
        }).subscribe(function (data) {
            console.log("You are already loggedin, redirecting to home page!!");
            _this.router.navigate(["/home"]);
        }, function (err) {
            console.error("Error Occured while loading auth data :: ", err.error);
        });
    };
    LoginFormComponent.prototype.login = function (loginForm) {
        var _this = this;
        this.loginErrorMessage = null;
        console.log(loginForm.value);
        console.log("USER OBJECT ", this.user);
        var body = "username=" + this.user.username + "&password=" + this.user.password;
        var url = __WEBPACK_IMPORTED_MODULE_2__environments_environment__["a" /* environment */].apiLogin;
        console.log("URL ", url);
        this.http.post(url, body, {
            headers: new __WEBPACK_IMPORTED_MODULE_1__angular_common_http__["c" /* HttpHeaders */]({ 'Content-Type': 'application/x-www-form-urlencoded' }),
            withCredentials: true
        }).subscribe(function (data) {
            console.log(data);
            _this.router.navigate(["/home"]);
        }, function (err) {
            console.error(err.error);
            _this.loginErrorMessage = err.error.message;
        });
    };
    LoginFormComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-login-form',
            template: __webpack_require__("../../../../../src/app/login-form/login-form.component.html"),
            styles: [__webpack_require__("../../../../../src/app/login-form/login-form.component.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__angular_common_http__["a" /* HttpClient */], __WEBPACK_IMPORTED_MODULE_3__angular_router__["a" /* Router */]])
    ], LoginFormComponent);
    return LoginFormComponent;
}());



/***/ }),

/***/ "../../../../../src/app/page-not-found/page-not-found.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/page-not-found/page-not-found.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\n  <h1>PAGE NOT FOUND !!!!!!!!!!!!!!!!!!</h1>\n</div>"

/***/ }),

/***/ "../../../../../src/app/page-not-found/page-not-found.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PageNotFoundComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var PageNotFoundComponent = (function () {
    function PageNotFoundComponent() {
    }
    PageNotFoundComponent.prototype.ngOnInit = function () {
    };
    PageNotFoundComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["n" /* Component */])({
            selector: 'app-page-not-found',
            template: __webpack_require__("../../../../../src/app/page-not-found/page-not-found.component.html"),
            styles: [__webpack_require__("../../../../../src/app/page-not-found/page-not-found.component.css")]
        }),
        __metadata("design:paramtypes", [])
    ], PageNotFoundComponent);
    return PageNotFoundComponent;
}());



/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
var restEndPoint = "";
var environment = {
    production: true,
    apiLogin: restEndPoint + "/api/login",
    apiLoginFB: restEndPoint + "/signin/facebook",
    apiLoginTwitter: restEndPoint + "/signin/twitter",
    apiLoginLinkedin: restEndPoint + "/signin/linkedin",
    apiLoginGoogle: restEndPoint + "/signin/google",
    apiLogOut: restEndPoint + "/api/logout",
    apiAuth: restEndPoint + "/api/auth"
};


/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_13" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map