var userid = args.id;

// Default admin if none provided
if(!userid){
	userid = "admin";
}

// Run as...
runAsUserUtil.runAs(
			userid, 
			function(){ 
				model.companyhomeList = companyhome.children;
				model.sitesList = siteService.listSites(null, null, 0);
			}
);
model.userid = userid;
