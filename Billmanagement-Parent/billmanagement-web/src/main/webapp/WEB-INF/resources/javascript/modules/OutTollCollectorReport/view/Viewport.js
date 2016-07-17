Ext.define('OutTollCollectorReportModule.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'OutTollCollectorReportModule.view.GridPanel'
    ],

    layout: 'fit',
    items: {
        xtype: 'gridpanel'
    }
});
