goog.provide("edu.kit.informatik.studyplan.client.view.components.uielement.Semester");
/**
 * @constructor
 * @param {Object=} options
 * @extends {Backbone.View}
 */

edu.kit.informatik.studyplan.client.view.components.uielement.Semester = Backbone.View.extend(/** @lends {edu.kit.informatik.studyplan.client.view.components.uielement.Semester.prototype} */{
    template: edu.kit.informatik.studyplan.client.model.system.TemplateManager.getInstance().getTemplate("resources/templates/components/uielement/semester.html"),
    tagName: "tr",
    model: null,
    moduleElements: [],
    initialize: function (options) {
        this.model = options.semester;
        this.isRemovable = options.isRemovable;
        this.isPreferencable = options.isPreferencable;
        this.reload();
        this.listenTo(this.model, "change", this.reload);
        this.listenTo(this.model, "all", this.reload);
        this.listenTo(this.model, "reset", this.reload);
        this.listenTo(this.model, "add", this.reload);
        this.reload();
    },
    reload: function () {
        this.moduleElements=[];
        this.model.each(function (el) {
            this.moduleElements.push(
                new edu.kit.informatik.studyplan.client.view.components.uielement.ModuleBox({
                    module: el,
                    isDraggable: true,
                    isRemovable: true,
                    isPreferencable: this.isPreferencable
                })
            );
        }.bind(this));
        this.render();
    },
    /**
     * @this {Backbone.View}
     * @suppress {missingProperties}
     * @return {Backbone.View|null}
     */
    render: function () {
        this.$el.html(this.template({
            semester: this.model
        }));
        this.$el.droppable({
            drop: this.onDrop.bind(this)
        });
        _.each(this.moduleElements, function (element) {
            element.render();
            this.$el.find(".semesterModules").append(element.$el);
        }.bind(this));
        return null;
    },
/**
*
*/
    removeSemester:
        function () {
            "use strict";
        },
    /**
    *@param{Event} event
    *@param{Object} ui
    */
    onDrop:function (event, ui) {
        console.info("[edu.kit.informatik.studyplan.client.view.components.uielement.Semester] drop event");
        //TODO: Make module deletable when it wasn't before!
        var droppedElement = ui.helper.data("viewObject");
        /**
         * @type {edu.kit.informatik.studyplan.client.model.module.Module}
         */
        var droppedModel = droppedElement.model;
        if (!(droppedModel.collection instanceof edu.kit.informatik.studyplan.client.model.plans.Semester)){
            droppedModel = /** @type {edu.kit.informatik.studyplan.client.model.module.Module} */(droppedModel.clone());
            droppedModel.collection = null;
            // Do not insert a module twice
            if (this.model.collection.containsModule(droppedModel.get('id'))) {
                console.log(droppedModel);
                console.log(this.model.collection);
                var LM = edu.kit.informatik.studyplan.client.model.system.LanguageManager.getInstance();
                edu.kit.informatik.studyplan.client.model.system.NotificationCollection.getInstance().add(
                    new edu.kit.informatik.studyplan.client.model.system.Notification({
                        title: LM.getMessage('notInsertTwiceTitle'),
                        text: LM.getMessage('notInsertTwiceText'),
                        wasShown: false,
                        type: "error"
                    })
                );
                return false;
            }
        }
        console.log(droppedModel);
        console.log(this.model);
        if (droppedModel.collection!==this.model) {
            if(droppedModel.collection!==null){
                droppedModel.collection.remove(droppedModel);
            }
            droppedModel.set('semester', this.model.semesterNum);
            this.model.add(droppedModel);
            droppedModel.collection = this.model;
            droppedModel.save();
        }
    },
    /**
    *
    */
    scrollLeft:
        function () {
            "use strict";
        },
    /**
    *
    */
    scrollRight:
        function () {
            "use strict";
        }
});