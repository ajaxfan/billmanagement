Ext.define('InTollCollectorReportModule.view.GridPanel', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.gridpanel',
	
	requires: [
       "Ext.plugins.QueryCriteriaToolbar"
	],
    defaults:{ sortable: true },
    columns: [{ 
    	xtype: 'rownumberer',
    	align: 'center',
        header: '序号',
    	width: 50
	}, {
        header: '票号',
        width: 160,
        dataIndex: 'billNo'
    }, {
        header: '名称',
        width: 140,
        dataIndex: 'billName'
    }, {
        header: '应收卡',
        width: 160,
        dataIndex: 'receivableCard'
    }, {
        header: '实收卡',
        width: 140,
        dataIndex: 'receiveCard'
    }, {
        header: 'passCar',
        width: 80,
        dataIndex: 'passCar'
    }, {
        header: 'noCard',
        width: 80,
        dataIndex: 'noCard'
    }, {
        header: 'arrears',
        width: 90,
        dataIndex: 'arrears'
    }, {
        header: 'totalFare',
        width: 90,
        align: 'right',
        dataIndex: 'totalFare'
    }, {
        header: 'receivableInvalid',
        width: 90,
        align: 'right',
        dataIndex: 'receivableInvalid'
    }, {
        header: 'receiveInvalid',
        width: 90,
        align: 'right',
        dataIndex: 'receiveInvalid'
    }, {
        header: 'invalidCard',
        width: 90,
        align: 'right',
        dataIndex: 'invalidCard'
    }, {
        header: 'militaryVehicle',
        width: 100,
        dataIndex: 'militaryVehicle'
    }, {
        header: 'freeCar',
        width: 100,
        dataIndex: 'freeCar'
    }, {
        header: 'ucrossCar',
        width: 100,
        dataIndex: 'ucrossCar'
    }, {
        header: 'manageCar',
        width: 100,
        dataIndex: 'manageCar'
    }, {
        header: 'harvester',
        width: 100,
        dataIndex: 'harvester'
    }, {
        header: 'urgentCar',
        width: 100,
        dataIndex: 'urgentCar'
    }, {
        header: 'billCount',
        width: 100,
        dataIndex: 'billCount'
    }],
    
    /**
     * Component Init
     */
    initComponent: function() {
    	// Create Store Object
    	var store = Ext.create('InTollCollectorReportModule.store.InTollCollectorReport');
    	
    	// Copy properties to Origin Object
    	Ext.apply(this, {
    		store: store,
    		tbar: {// Top bar
    			xtype: 'querycriteriatoolbar',
            	store: store, 
            	label: '车牌号', 
            	paramName: 'carCode',
            	hideAxisum: true
    		}
    	});
    	// Call Parent Constructor
        this.callParent(arguments);
    }
});