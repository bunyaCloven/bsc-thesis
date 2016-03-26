Ext.define('Beeride.view.CarpoolFilter', {
	extend : 'Ext.form.Panel',
	config : {
		layout : 'vbox',
		xtype : 'fieldset',
		url : serverAddress + '/paths/add',
		items : [ {
			xtype : 'hiddenfield',
			name : 'id'
		}, {
			xtype : 'textfield',
			placeHolder : 'Name',
			name : 'name'
		}, {
			xtype : 'panel',
			layout : 'hbox',
			items : [ {
				xtype : 'textfield',
				name : 'start',
				placeHolder : 'Start Point',
				readOnly : true,
				flex : 1
			}, {
				xtype : 'button',
				iconCls : 'locate',
				itemId : 'locate'
			} ]
		}, {
			flex : 1
		}, {
			xtype : 'toolbar',
			items : [ {
				xtype : 'spacer'
			}, {
				iconCls : 'action',
				handler : function() {
					var store = Ext.data.StoreManager.lookup('Carpools');
					var proxy = store.getProxy();
					var name = this.up('formpanel').down('[name=name]');
					var start = this.up('formpanel').down('[name=start]');
					proxy.setExtraParam('name', name.getValue());
					proxy.setExtraParam('start', start.getValue());
					var form = this.up('formpanel');
					form.up().remove(form);
				}
			}, {
				xtype : 'spacer'
			}, {
				iconCls : 'delete',
				handler : function() {
					this.up('formpanel').down('[name=name]').setValue(null);
					this.up('formpanel').down('[name=start]').setValue(null);
				}
			}, {
				xtype : 'spacer'
			} ]
		} ]
	}
});