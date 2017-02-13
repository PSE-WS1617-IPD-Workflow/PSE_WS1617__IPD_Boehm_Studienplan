goog.provide("edu.kit.informatik.studyplan.client.view.components.uielement.PlanListElement");
/**
 * @constructor
 * @param {Object} options
 * @extends {Backbone.View}
 */

edu.kit.informatik.studyplan.client.view.components.uielement.PlanListElement = Backbone.View.extend(/** @lends {edu.kit.informatik.studyplan.client.view.components.uielement.PlanListElement.prototype} */{
    tagName: 'tr',
    template: edu.kit.informatik.studyplan.client.model.system.TemplateManager.getInstance().getTemplate("resources/templates/components/uielement/planListEl.html"),
    plan: null,
    events: {
        "click button.showPlan": "showPlan",
        "click button.duplicatePlan": "duplicatePlan",
        "click button.deletePlan": "deletePlan",
        "click button.exportPlan": "exportPlan",
    },
    initialize: function (options) {
        this.plan = options.plan;
    },
    render: function () {
        this.$el.html(this.template({plan: this.plan}));
        this.delegateEvents();
    },
    /**
    *
    */
    showPlan: function () {
        "use strict";
        console.log("[edu.kit.informatik.studyplan.client.view.components.uielement.PlanListElement] showPlan");
        edu.kit.informatik.studyplan.client.router.MainRouter.getInstance().navigate("plans/"+this.plan.get('id'),{trigger:true});
    },
    /**
    *
    */
    exportPlan: function () {
        "use strict";
        console.log("[edu.kit.informatik.studyplan.client.view.components.uielement.PlanListElement] exportPlan");
        window.location.href=API_DOMAIN+"/plans/"+this.plan.get('id')+"/pdf?access-token="+edu.kit.informatik.studyplan.client.model.user.SessionInformation.getInstance().get('access_token');
    },
    /**
    *
    */
    duplicatePlan: function () {
        "use strict";
        console.log("[edu.kit.informatik.studyplan.client.view.components.uielement.PlanListElement] duplicatePlan");
        var planName= prompt(edu.kit.informatik.studyplan.client.model.system.LanguageManager.getInstance().getMessage("planNameQuestion"), "");
        if(planName===null){
            return;
        }
        var self = this;
        edu.kit.informatik.studyplan.client.router.MainRouter.getInstance().showLoading();
        this.plan.fetch({
            // TODO: zurück stellen, wenn nicht erfolgreich
            success: function () {
                var attributes = _.clone(self.plan.attributes);
                delete attributes["id"];
                attributes["name"]=planName;
                var newPlan = new edu.kit.informatik.studyplan.client.model.plans.Plan(attributes);
                // Add to collection
                self.plan.collection.add(newPlan);
                // Send POST request
                newPlan.save({},{
                    success: function () {
                        // Send PUT request
                        newPlan.save({}, {
                            success: function () {
                                edu.kit.informatik.studyplan.client.router.MainRouter.getInstance().hideLoading();
                                edu.kit.informatik.studyplan.client.model.system.NotificationCollection.getInstance().add(
                                    new edu.kit.informatik.studyplan.client.model.system.Notification({
                                        title: LM.getMessage("planDuplicatedTitle"),
                                        text: LM.getMessage("planDuplicatedText"),
                                        wasShown: false,
                                        type: "success"
                                    })
                                );
                            },
                            patch: false
                        });
                    }
                });
            }
        });
    },
    /**
    *
    */
    deletePlan: function () {
        "use strict";
        console.log("[edu.kit.informatik.studyplan.client.view.components.uielement.PlanListElement] deletePlan");
        var LM = edu.kit.informatik.studyplan.client.model.system.LanguageManager.getInstance();
        edu.kit.informatik.studyplan.client.router.MainRouter.getInstance().showLoading();
        this.plan.destroy({success: function () {
            edu.kit.informatik.studyplan.client.router.MainRouter.getInstance().hideLoading();
            edu.kit.informatik.studyplan.client.model.system.NotificationCollection.getInstance().add(
                new edu.kit.informatik.studyplan.client.model.system.Notification({
                    title: LM.getMessage("planDeletedTitle"),
                    text: LM.getMessage("planDeletedText"),
                    wasShown: false,
                    type: "success"
                })
            );
        }});
    },
    setChecked: function (isChecked) {
        this.$el.find("input[type=checkbox]").prop('checked', isChecked);
    },
    isChecked: function () {
        return  this.$el.find("input[type=checkbox]").prop('checked');
    }
});