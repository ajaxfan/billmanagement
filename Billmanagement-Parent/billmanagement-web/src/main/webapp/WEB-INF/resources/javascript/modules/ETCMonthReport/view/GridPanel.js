Ext.define('ETCMonthReportModule.view.GridPanel', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.gridpanel',
	requires: ["Ext.ux.MonthField"],
	
    defaults:{ sortable: false },
    columns: [{ 
    	xtype: 'rownumberer',
    	align: 'center',
        header: '序号',
    	width: 50
	}, {
        header: '员工编号',
        width: 80,
        dataIndex: 'employeeNo'
    }, {
        header: '员工名',
        width: 80,
        dataIndex: 'employeeName'
    }, {
        header: '应收金额',
        width: 80,
        dataIndex: 'receivableFare'
    }, {
        header: '实收金额',
        width: 80,
        dataIndex: 'receiveFare'
    }, {
        header: '1型',
        width: 60,
        dataIndex: 'typeOne'
    }, {
        header: '2型',
        width: 60,
        dataIndex: 'typeTwo'
    }, {
        header: '3型',
        width: 60,
        dataIndex: 'typeThree'
    }, {
        header: '4型',
        width: 60,
        dataIndex: 'typeFour'
    }, {
        header: '5型',
        width: 60,
        dataIndex: 'typeFive'
    }, {
        header: '总车流量',
        width: 90,
        dataIndex: 'totalCarCount'
    }],
    
    /**
     * Component Init
     */
    initComponent: function() {
    	// Create Store Object
    	var store = Ext.create('ETCMonthReportModule.store.ETCMonthReport');
    	
    	// Copy properties to Origin Object
    	Ext.apply(this, {
    		store: store,
    		tbar: Ext.create('Ext.toolbar.Toolbar', {
                items: [{
            		fieldLabel: '统计日期',
            		labelAlign: 'right',
            		width: 170,
            		labelWidth: 80,
    	           	id: 'beginDate',
    	   	        xtype: 'monthfield',
    	   	        format: 'Y/m',
    	   	        editable: false,
    	   	        value: new Date()
            	}, {
                    text: '查询',
                    iconCls: 'search',
                    action: 'search',
	 	   		    listeners: {
		   			   click: function() {
		   				    var proxy = store.getProxy();
			   		        var beginDate = Ext.util.Format.date(Ext.getCmp("beginDate").getValue(), 'Y/m');
			   		        proxy.extraParams = store.baseParams || {};
			   		        proxy.extraParams["beginDate"] = beginDate;// 要统计的日期
			   		        
			   		        store.reload();
		   			   }
		   		    }
                }, '->', {
                    text: '打印报表',
      	   		    id: 'searchBtn',
                    iconCls: 'print',
                    action: 'del',
	 	   		    listeners: {
		   			   click: function() {
		   				    var applet = document.getElementById("reportApplet");
		   				    
		   				    applet.ppr("etcMonthReport", {date: store.getProxy().extraParams["beginDate"]});
		   			   }
		   		    }
                }]
            })
    	});
    	// Call Parent Constructor
        this.callParent(arguments);
    }
});