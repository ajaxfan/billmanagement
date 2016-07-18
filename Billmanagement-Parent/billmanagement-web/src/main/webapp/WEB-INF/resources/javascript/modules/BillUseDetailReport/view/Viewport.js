Ext.define('BillUseDetailModule.view.Viewport', {
    extend: 'Ext.container.Viewport',

    requires: [
        'BillUseDetailModule.view.GridPanel'
    ],

    layout: 'fit',
    items: {
        xtype: 'gridpanel'
    }
});
