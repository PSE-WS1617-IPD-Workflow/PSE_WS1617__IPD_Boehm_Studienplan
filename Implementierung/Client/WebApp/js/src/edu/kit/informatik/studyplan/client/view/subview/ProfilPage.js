goog.provide("edu.kit.informatik.studyplan.client.view.subview.ProfilPage");
/**
 * @constructor
 * @extends {Backbone.View}
 */

edu.kit.informatik.studyplan.client.view.subview.ProfilPage = Backbone.View.extend(/** @lends {edu.kit.informatik.studyplan.client.view.subview.ProfilPage.prototype} */{
    template: edu.kit.informatik.studyplan.client.model.system.TemplateManager.getInstance().getTemplate("resources/templates/subview/profilPage.html"),
    
    moduleFinder: null,
    events: {
      "click button.mainPageNavigation": "navigateToMainPage"  
    },    
    initialize: function (){
        this.moduleFinder = new edu.kit.informatik.studyplan.client.view.components.uielement.ModuleFinder({
            isDraggable: true,
            isPreferencable: false
        });
    },
    
    /**
    *
    */
    close: function () {
        "use strict";
    },
    /**
    *@param {edu.kit.informatik.studyplan.client.model.module.Module} module
    */
    showModuleDetails:
        function (module) {
            "use strict";
    },
    /**
    * @this {Backbone.View}
    * @return *    
    */
    render: function () {
        "use strict";
        this.$el.html(this.template());
        var finder = this.$el.find(".profileEditModuleFinderWrapper");
        
        this.moduleFinder.render();
        finder.append(this.moduleFinder.$el);
        
        this.delegateEvents();
    },
    /**
    *
    */
    hideModuleDetails: function () {
            "use strict";
    },
    navigateToMainPage: function () {
        edu.kit.informatik.studyplan.client.router.MainRouter.getInstance().navigate("/",{trigger:true});
    }
});
