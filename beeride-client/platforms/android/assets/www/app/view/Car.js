Ext.define('Beeride.view.Car', {
	extend : 'Ext.form.Panel',
	config : {
		layout : 'vbox',
		items : [ {
			xtype : 'label',
			name : 'name',
			html : 'Car Name: '
		}, {
			xtype : 'label',
			name : 'brand',
			html : 'Car Brand & Model: '
		}, {
			xtype : 'label',
			name : 'passengerCount',
			html : 'Passenger Count: '
		}, {
			flex : 1
		} ]
	}
});