var StudyplanApp={Exceptions:{}};StudyplanApp.Exceptions.AppException=function(){};StudyplanApp.Exceptions.TemplateNotFoundException=function(a){this.key=a};StudyplanApp.Templating={};StudyplanApp.Templating.TemplateRegistryInterface=function(){};StudyplanApp.Templating.TemplateRegistryInterface.prototype.getTemplate=function(a){};StudyplanApp.Templating.TemplateRegistryInterface.prototype.addTemplate=function(a,c){};StudyplanApp.Templating.TemplateRegistry=function(){function a(){this.templates={};this.addTemplate=function(d,a){this.templates[d]=_.template(a)};this.getTemplate=function(a){if("undefined"!==typeof this.templates[a])return this.templates[a];console.error("[TemplateFactory] Cannot find template '"+a+"'.");throw new StudyplanApp.Exceptions.TemplateNotFoundException(a);}}var c=null;return{getInstance:function(){null===c&&(c=new a);return c}}}();StudyplanApp.Sync={};StudyplanApp.Sync.CookieSync=function(a,c,d){var f=c.url();d.cookieName=f;var e={create:function(a,b){Cookies.set(b.cookieName,a)},read:function(a,b){return Cookies.getJSON(b.cookieName)},update:function(a,b){if(b.patch){var c=Cookies.getJSON(b.cookieName);_.map(a.toJSON(),function(a,b){c[b]=a});e.create(c,b)}else e.create(a,b)},"delete":function(a,b){Cookies.remove(b.cookieName)}};return e[a](c,d)};function TemplateLoader(){this.templates=this.templates||{};this.templates["templates/wrapper.html"]=function(a){return'<div id="appWrapper">\r\n    <div id="header">\r\n        <div id="icon">\r\n            <h1>StudyPlan</h1>\r\n        </div>\r\n    </div>\r\n    <div id="content">\r\n    \r\n    </div>\r\n</div>'}}TemplateLoader.bind(StudyplanApp.Templating.TemplateRegistry.getInstance())();StudyplanApp.Views={};StudyplanApp.Views.AppView=Backbone.View.extend({el:"body",template:StudyplanApp.Templating.TemplateRegistry.getInstance().getTemplate("templates/wrapper.html"),initialize:function(){this.render()},render:function(){this.$el.html(this.template());this.$el.show()}});