Ext.define('Beeride.store.Seats', {
	extend : 'Ext.data.Store',
	config : {
		model : 'Beeride.model.Seat',
		proxy : {
			headers : {
				Authorization : Beeride.util.Auth.get()
			},
			extraParams : {},
			type : 'ajax',
			url : serverAddress + "/seats",
			reader : {
				type : "json",
				rootProperty : "data"
			}
		},
		autoLoad : false
	}
});