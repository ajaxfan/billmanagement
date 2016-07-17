Ext.define('BillUseDetailModule.view.GridPanel', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.gridpanel',
	
    defaults:{ sortable: false},
    columns: [{ 
        header: '时间段',
    	width: 160
	}, {
        header: '编号',
        width: 80,
        dataIndex: 'employeeNo'
    }, {
        header: '摘要',
        width: 80,
        dataIndex: 'employeeName'
    }, {
        header: '领用数',
        columns: [{
            header: '起始号',
            width: 140,
            dataIndex: 'orderNo'
        },{
            header: '终止哈',
            width: 140,
            dataIndex: 'orderNo'
        },{
            header: '总数',
            width: 140,
            dataIndex: 'orderNo'
        }]
    }, {
        header: '核销数',
        columns: [{
            header: '售出',
            columns: [{
                header: '起始号',
                width: 140,
                dataIndex: 'orderNo'
            },{
                header: '终止哈',
                width: 140,
                dataIndex: 'orderNo'
            },{
                header: '总数',
                width: 140,
                dataIndex: 'orderNo'
            }]
        },{
            header: '作废',
            columns: [{
                header: '起始号',
                width: 140,
                dataIndex: 'orderNo'
            },{
                header: '终止哈',
                width: 140,
                dataIndex: 'orderNo'
            },{
                header: '总数',
                width: 140,
                dataIndex: 'orderNo'
            }]
        },{
            header: '小计',
            columns: [{
                header: '起始号',
                width: 140,
                dataIndex: 'orderNo'
            },{
                header: '终止哈',
                width: 140,
                dataIndex: 'orderNo'
            },{
                header: '总数',
                width: 140,
                dataIndex: 'orderNo'
            }]
        }]
    }, {
        header: '结存数',
        columns: [{
            header: '起始号',
            width: 140,
            dataIndex: 'orderNo'
        },{
            header: '终止哈',
            width: 140,
            dataIndex: 'orderNo'
        },{
            header: '总数',
            width: 140,
            dataIndex: 'orderNo'
        }]
    }],
    
    /**
     * Component Init
     */
    initComponent: function() {
    	// Create Store Object
    	var store = Ext.create('BillUseDetailModule.store.BillUseDetail');
    	
    	// Copy properties to Origin Object
    	Ext.apply(this, {
    		store: store,
    		tbar: Ext.create('Ext.toolbar.Toolbar', {
                items: [{
            		fieldLabel: '开始日期',
            		labelAlign: 'right',
            		width: 190,
            		labelWidth: 80,
    	           	id: 'beginDate',
    	   	        xtype: 'datefield',
    	   	        format: 'Y/m/d',
    	   	        editable: false,
    	   	        value: new Date()
            	},{
            		fieldLabel: '结束日期',
            		labelAlign: 'right',
            		width: 190,
            		labelWidth: 70,
    	           	id: 'endDate',
    	   	        xtype: 'datefield',
    	   	        format: 'Y/m/d',
    	   	        editable: false,
    	   			value: Ext.Date.add(new Date(), Ext.Date.DAY, 1)
            	}, {
                    text: '查询',
                    iconCls: 'search',
                    action: 'search',
	 	   		    listeners: {
		   			   click: function() {
		   				    var proxy = store.getProxy();
			   		        var beginDate = Ext.util.Format.date(Ext.getCmp("beginDate").getValue(), 'Y/m/d');
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
		   				    
		   				    applet.ppr("billUseDetailReport", {date: store.getProxy().extraParams["beginDate"]});
		   			   }
		   		    }
                }]
            })
    	});
    	// Call Parent Constructor
        this.callParent(arguments);
    }
});