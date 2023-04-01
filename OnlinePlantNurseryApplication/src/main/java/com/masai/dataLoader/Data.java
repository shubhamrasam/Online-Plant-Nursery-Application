package com.masai.dataLoader;

import com.masai.model.Plant;
import com.masai.model.Planter;
import com.masai.model.Seed;
import com.masai.repository.PlantRepository;
import com.masai.repository.PlanterRepository;
import com.masai.repository.SeedRepository;

public class Data {
     
	public void addPlantData(PlantRepository plantrepo) {
		String url1 = "https://user-images.githubusercontent.com/87129673/229049195-c7f5e63c-cf5d-4b76;-aa4e-3f5fee1d7627.JPG";
		String url2 = "https://user-images.githubusercontent.com/87129673/229049203-d05ca6f3-1be5-4333-96ff-a4e008f6519c.JPG";
		String url3 = "https://user-images.githubusercontent.com/87129673/229049209-4277694b-e5c1-496c-9fa6-f3ef63377703.JPG";
		String url4 = "https://user-images.githubusercontent.com/87129673/229049213-d9131c15-1e62-4dd3-b789-6287982e1df6.JPG";
		String url5 = "https://user-images.githubusercontent.com/87129673/229049216-45316c17-d745-41bc-849b-308850b94589.JPG";
		String url6 = "https://user-images.githubusercontent.com/87129673/229049222-0e849ffb-eb52-4765-bfc2-2b95c1a32767.JPG";
		String url7 = "https://user-images.githubusercontent.com/87129673/229049226-6d40da4a-61a9-4f85-8449-51617f109e3a.JPG";
		String url8 = "https://user-images.githubusercontent.com/87129673/229049232-5cc1cafc-6ee9-417b-ab85-1146226ccae7.JPG";
		String url9 = "https://user-images.githubusercontent.com/87129673/229049240-f7f216ce-b07c-4efe-9f5c-1f2674338e44.JPG";
		String url10 = "https://user-images.githubusercontent.com/87129673/229049248-778c9d46-a161-49db-9462-6833dd390ab2.JPG";
		String url11 = "https://user-images.githubusercontent.com/87129673/229049251-2849605e-7ee0-4a03-8075-3bedab5b0b46.JPG";
		String url12 = "https://user-images.githubusercontent.com/87129673/229049256-84f16a2d-db81-4c10-9c15-df10ec53252f.JPG";
		String url13 = "https://user-images.githubusercontent.com/87129673/229049259-16597b32-56af-4bc2-98e5-df5005241c86.JPG";
		String url14 = "https://user-images.githubusercontent.com/87129673/229049261-6b56d05f-cf37-4956-9caa-464c93da2b09.JPG";
		String url15 = "https://user-images.githubusercontent.com/87129673/229049266-c1539203-2e14-4b44-bff1-c231b96e2d22.JPG";
		String url16 = "https://user-images.githubusercontent.com/87129673/229049269-2c8a85fc-f2b8-4550-89e3-fac06c948b62.JPG";
		String url17 = "https://user-images.githubusercontent.com/87129673/229049274-7a144fcb-5aac-4543-9e30-5739189d0186.JPG";
		String url18 = "https://user-images.githubusercontent.com/87129673/229049277-029142c3-7b70-4455-a60e-f6ddb922ed2d.JPG";
		String url19 = "https://user-images.githubusercontent.com/87129673/229049284-cacdc1c2-bdef-46da-b8bf-1d451a0b9093.JPG";
		String url20 = "https://user-images.githubusercontent.com/87129673/229049289-1bdb5372-2627-43ae-8479-8c69b86b5c35.JPG";
		String url21 = "https://user-images.githubusercontent.com/87129673/229049294-827ad9ab-c95c-48a0-b643-322bc9a48bba.JPG";
		String url22 = "https://user-images.githubusercontent.com/87129673/229049298-8567d5ac-3c3d-4f1e-8d6c-fe1373b49d5b.JPG";
		String url23 = "https://user-images.githubusercontent.com/87129673/229049304-00855a38-f307-4f40-8a91-4ebcada8af0c.JPG";
		String url24 = "https://user-images.githubusercontent.com/87129673/229049307-6940a147-2b5a-414f-9988-2a7995b7876b.JPG";
		String url25 = "https://user-images.githubusercontent.com/87129673/229049309-76a09659-f5cc-46ae-8c60-f3067a03a86a.JPG";
		String url26 = "https://user-images.githubusercontent.com/87129673/229049311-8d3d52b8-2e29-4551-99bd-da5977c08dc1.JPG";
		String url27 = "https://user-images.githubusercontent.com/87129673/229049315-ae2adf3d-98dd-4943-bd8e-76d676f17f9b.JPG";
		String url28 = "https://user-images.githubusercontent.com/87129673/229049321-9ccaab8d-deb9-444d-90d8-911e24399c50.JPG";
		String url29 = "https://user-images.githubusercontent.com/87129673/229049326-2cde0b4f-5afe-41f3-a13a-ed74ebe3b69c.JPG";
		String url30 = "https://user-images.githubusercontent.com/87129673/229049329-3092ee34-94be-452c-b7f3-41d81bfec3e9.JPG";
		String url31 = "https://user-images.githubusercontent.com/87129673/229049334-59dc9c39-940c-4446-9b59-f348d917de83.JPG";
		String url32 = "https://user-images.githubusercontent.com/87129673/229049338-20189fae-ad7c-4c5f-90d9-0c91030ed8cd.JPG";
		String url33 = "https://user-images.githubusercontent.com/87129673/229049341-44204f4b-e89b-4399-b43e-25e91e4b3caf.JPG";
		String url34 = "https://user-images.githubusercontent.com/87129673/229049347-5ef50a9b-e4ef-4670-9de5-7364a3511073.JPG";
		String url35 = "https://user-images.githubusercontent.com/87129673/229049350-25e60f76-6684-42e1-a941-d821bb80bd66.JPG";
		String url36 = "https://user-images.githubusercontent.com/87129673/229049354-5e7d0c74-eeca-4d04-b224-4f277a54f72e.JPG";
		String url37 = "https://user-images.githubusercontent.com/87129673/229049358-863e3b3c-91ec-4736-8501-ab570349c277.JPG";
		String url38 = "https://user-images.githubusercontent.com/87129673/229049362-adef92ab-92f6-470e-9eb0-74627858777d.JPG";
		String url39 = "https://user-images.githubusercontent.com/87129673/229049368-4670a487-4ebc-4e83-bfb1-586d7f21568d.JPG";
		String url40 = "https://user-images.githubusercontent.com/87129673/229049372-a5f758e8-475f-4fe4-ac65-18bdd3fec2dc.JPG";
		String url41 = "https://user-images.githubusercontent.com/87129673/229049373-72f8f9e6-c313-4dd6-a276-2ef7fc109008.JPG";
		String url42 = "https://user-images.githubusercontent.com/87129673/229049377-62bf3f93-b139-4a0e-8e64-6d3b539b7a74.JPG";
		String url43 = "https://user-images.githubusercontent.com/87129673/229049381-e27af981-2acd-4704-8c9f-7e890b7c3300.JPG";
		String url44 = "https://user-images.githubusercontent.com/87129673/229049383-3c8464a4-a81e-44e5-b017-8ca1b2623b6c.JPG";
		String url45 = "https://user-images.githubusercontent.com/87129673/229049385-ba6da16e-6e37-429f-8705-317fe60a2337.JPG";
		String url46 = "https://user-images.githubusercontent.com/87129673/229049389-6137a4a2-05e1-4078-81d8-3cde92558d05.JPG";
		String url47 = "https://user-images.githubusercontent.com/87129673/229049394-54abfc8d-1377-4372-8283-c29aa71b7fb7.JPG";
		String url48 = "https://user-images.githubusercontent.com/87129673/229049399-88b370ff-61ac-48f5-af89-2a63a48ecb99.JPG";
		String url49 = "https://user-images.githubusercontent.com/87129673/229049404-a09c1484-d4ac-4757-9172-119993cd16f7.JPG";
		String url50 = "https://user-images.githubusercontent.com/87129673/229049409-5a57e2d9-1303-49c5-9342-53d978065af3.JPG";
		Double price1 = 454.0;
		Double price2 = 445.0;
		Double price3 = 5656.0;
		Double price4 = 450.0;
		Double price5 = 656.0;
		Double price6 = 878.0;
		Double price7 = 456.0;
		Double price8 = 121.0;
		Double price9 = 487.0;
		Double price10 = 422.0;
		Double price11 = 121.0;
		Double price12 = 456.0;
		Double price13 = 235.0;
		Double price14 = 54.0;
		Double price15 = 875.0;
		Double price16 = 545.0;
		Double price17 = 893.0;
		Double price18 = 697.0;
		Double price19 = 399.0;
		Double price20 = 299.0;
		Double price21 = 899.0;
		Double price22 = 456.0;
		Double price23 = 896.0;
		Double price24 = 362.0;
		Double price25 = 899.0;
		Double price26 = 236.0;
		Double price27 = 456.0;
		Double price28 = 653.0;
		Double price29 = 362.0;
		Double price30 = 362.0;
		Double price31 = 562.0;
		Double price32 = 362.0;
		Double price33 = 499.0;
		Double price34 = 699.0;
		Double price35 = 236.0;
		Double price36 = 199.0;
		Double price37 = 399.0;
		Double price38 = 954.0;
		Double price39 = 463.0;
		Double price40 = 872.0;
		Double price41 = 545.0;
		Double price42 = 599.0;
		Double price43 = 557.0;
		Double price44 = 454.0;
		Double price45 = 215.0;
		Double price46 = 545.0;
		Double price47 = 656.0;
		Double price48 = 212.0;
		Double price49 = 455.0;
		Double price50 = 121.0;
		String name1 = "snake-plant-golden-hahnii";
		String name2 = "the-china-doll-plant-x";
		String name3 = "the-low-maintenance-bundle";
		String name4 = "the-sleep-better-bundl";
		String name5 = "thuja-plant-xl";
		String name6 = "twisted-hoya";
		String name7 = "wandering-jew-with-hanging-pot";
		String name8 = "zz-plant-xl";
		String name9 = "philodendron-oxycardium-golden-plant-with-moss-stick";
		String name10 = "aglaonema-manila-beauty-xl";
		String name11 = "aralia-variegated-mini-plant";
		String name12 = "areca-palm-plant-xl";
		String name13 = "betel-leaf-plant-magai-paan";
		String name14 = "broken-heart-plant";
		String name15 = "christmas-cactus";
		String name16 = "draceana-dara-singh-xl";
		String name17 = "echeveria-subsesilis-hybrid-silver-plant";
		String name18 = "fern-morpankhi";
		String name19 = "ficus-moclame-plant-xl-";
		String name20 = "fittonia-green-plant-nerve-plant";
		String name21 = "golden-sedum-plant";
		String name22 = "ixora-rugmini-plant-pink";
		String name23 = "kalanchoe-plant-orange";
		String name24 = "kalanchoe-plant-pink";
		String name25 = "kalanchoe-plant-red-31793426923652";
		String name26 = "kesar-mango-plant";
		String name27 = "large-fiddle-leaf-fig-plant-bambino";
		String name28 = "lemon-grass";
		String name29 = "lucky-bamboo-plant-3-layer";
		String name30 = "medium-areca-palm-plant";
		String name31 = "medium-bird-of-paradise-plant-";
		String name32 = "medium-croton-petra";
		String name33 = "medium-rubber-plan";
		String name34 = "medium-zz-plant";
		String name35 = "money-plant-golden";
		String name36 = "money-plant-golden-plant-set-of";
		String name37 = "money-plant-variegated";
		String name38 = "monstera-deliciosa-plant";
		String name39 = "monstera-deliciosa-plants";
		String name40 = "monstera-deliciosa-plant-xl";
		String name41 = "netted-ficus-tree";
		String name42 = "peace-lily-plant-set-of";
		String name43 = "peperomia-green-plant";
		String name44 = "philodendron-micans-plant";
		String name45 = "raphis-palm-xl";
		String name46 = "sansevieria-laurentii-plant-x";
		String name47 = "small-anthurium-red-plant";
		String name48 = "small-chlorophytum-spider-plant";
		String name49 = "small-jade-plant-mini";
		String name50 = "small-stromanthe-triostar-plant";
		Plant plant1 = new Plant(1, "small", name1, "Jan", "yes", "high", "30.c", "medicinal",
				"verygood Plant for show", 36, price1, url1);
		Plant plant2 = new Plant(2, "small", name2, "mar", "No", "high", "30.c", "showcase", "verygood Plant for show",
				35, price2, url2);
		Plant plant3 = new Plant(3, "small", name3, "feb", "No", "high", "30.c", "Non-medicinal",
				"verygood Plant for show", 32, price3, url3);
		Plant plant4 = new Plant(4, "small", name4, "April", "yes", "high", "30.c", "flower", "verygood Plant for show",
				34, price4, url4);
		Plant plant5 = new Plant(5, "small", name5, "May", "yes", "high", "30.c", "froot", "verygood Plant for show",
				33, price5, url5);
		Plant plant6 = new Plant(6, "small", name6, "feb", "No", "high", "30.c", "veg", "verygood Plant for show", 66,
				price6, url6);
		Plant plant7 = new Plant(7, "small", name7, "July", "yes", "high", "30.c", "flower", "verygood Plant for show",
				86, price7, url7);
		Plant plant8 = new Plant(8, "small", name8, "Dec", "No", "high", "30.c", "medicinal", "verygood Plant for show",
				96, price8, url8);
		Plant plant9 = new Plant(9, "small", name9, "Jan", "No", "high", "30.c", "American", "verygood Plant for show",
				26, price9, url9);
		Plant plant10 = new Plant(10, "small", name10, "Sept", "yes", "high", "30.c", "Fruit",
				"verygood Plant for show", 66, price1, url10);
		Plant plant11 = new Plant(11, "small", name11, "Jan", "yes", "high", "30.c", "medicinal",
				"verygood Plant for show", 36, price11, url11);
		Plant plant12 = new Plant(12, "small", name12, "mar", "No", "high", "35.c", "showcase",
				"verygood Plant for show", 36, price12, url12);
		Plant plant13 = new Plant(13, "small", name13, "feb", "No", "high", "36.c", "Non-medicinal",
				"verygood Plant for show", 36, price13, url13);
		Plant plant14 = new Plant(14, "small", name14, "April", "yes", "high", "65.c", "flower",
				"verygood Plant for show", 36, price14, url14);
		Plant plant15 = new Plant(15, "small", name15, "May", "yes", "high", "30.c", "froot", "verygood Plant for show",
				36, price15, url15);
		Plant plant16 = new Plant(16, "small", name16, "feb", "No", "high", "33.c", "veg", "verygood Plant for show",
				36, price16, url16);
		Plant plant17 = new Plant(17, "small", name17, "July", "yes", "high", "30.c", "flower",
				"verygood Plant for show", 36, price17, url17);
		Plant plant18 = new Plant(18, "small", name18, "Dec", "No", "high", "39.c", "medicinal",
				"verygood Plant for show", 36, price18, url18);
		Plant plant19 = new Plant(19, "small", name19, "Jan", "No", "high", "40.c", "American",
				"verygood Plant for show", 36, price19, url19);
		Plant plant20 = new Plant(20, "small", name20, "Sept", "yes", "high", "40.c", "Fruit",
				"verygood Plant for show", 36, price20, url20);
		Plant plant21 = new Plant(21, "small", name21, "Jan", "yes", "high", "30.c", "medicinal",
				"verygood Plant for show", 36, price21, url21);
		Plant plant22 = new Plant(22, "small", name22, "mar", "No", "high", "30.c", "showcase",
				"verygood Plant for show", 35, price22, url22);
		Plant plant23 = new Plant(23, "small", name23, "feb", "No", "high", "30.c", "Non-medicinal",
				"verygood Plant for show", 32, price23, url23);
		Plant plant24 = new Plant(24, "small", name24, "April", "yes", "high", "30.c", "flower",
				"verygood Plant for show", 34, price24, url24);
		Plant plant25 = new Plant(25, "small", name25, "May", "yes", "high", "30.c", "froot", "verygood Plant for show",
				33, price25, url25);
		Plant plant26 = new Plant(26, "small", name26, "feb", "No", "high", "30.c", "veg", "verygood Plant for show",
				66, price26, url26);
		Plant plant27 = new Plant(27, "small", name27, "July", "yes", "high", "30.c", "flower",
				"verygood Plant for show", 86, price27, url27);
		Plant plant28 = new Plant(28, "small", name28, "Dec", "No", "high", "30.c", "medicinal",
				"verygood Plant for show", 96, price28, url28);
		Plant plant29 = new Plant(29, "small", name29, "Jan", "No", "high", "30.c", "American",
				"verygood Plant for show", 26, price29, url29);
		Plant plant30 = new Plant(30, "small", name30, "Sept", "yes", "high", "30.c", "Fruit",
				"verygood Plant for show", 66, price30, url30);
		Plant plant31 = new Plant(31, "small", name31, "Jan", "yes", "high", "30.c", "medicinal",
				"verygood Plant for show", 36, price31, url31);
		Plant plant32 = new Plant(32, "small", name32, "mar", "No", "high", "30.c", "showcase",
				"verygood Plant for show", 35, price32, url32);
		Plant plant33 = new Plant(33, "small", name33, "feb", "No", "high", "30.c", "Non-medicinal",
				"verygood Plant for show", 332, price3, url33);
		Plant plant34 = new Plant(34, "small", name34, "April", "yes", "high", "30.c", "flower",
				"verygood Plant for show", 34, price34, url34);
		Plant plant35 = new Plant(35, "small", name35, "May", "yes", "high", "30.c", "froot", "verygood Plant for show",
				33, price35, url35);
		Plant plant36 = new Plant(36, "small", name36, "feb", "No", "high", "30.c", "veg", "verygood Plant for show",
				66, price36, url36);
		Plant plant37 = new Plant(37, "small", name37, "July", "yes", "high", "30.c", "flower",
				"verygood Plant for show", 86, price37, url37);
		Plant plant38 = new Plant(38, "small", name38, "Dec", "No", "high", "30.c", "medicinal",
				"verygood Plant for show", 96, price38, url38);
		Plant plant39 = new Plant(39, "small", name39, "Jan", "No", "high", "30.c", "American",
				"verygood Plant for show", 26, price39, url39);
		Plant plant40 = new Plant(40, "small", name40, "Sept", "yes", "high", "30.c", "Fruit",
				"verygood Plant for show", 66, price40, url40);

		Plant plant41 = new Plant(41, "small", name41, "Jan", "yes", "high", "30.c", "medicinal",
				"verygood Plant for show", 36, price41, url41);
		Plant plant42 = new Plant(42, "small", name42, "mar", "No", "high", "30.c", "showcase",
				"verygood Plant for show", 35, price42, url42);
		Plant plant43 = new Plant(43, "small", name43, "feb", "No", "high", "30.c", "Non-medicinal",
				"verygood Plant for show", 32, price43, url43);
		Plant plant44 = new Plant(44, "small", name44, "April", "yes", "high", "30.c", "flower",
				"verygood Plant for show", 34, price44, url44);
		Plant plant45 = new Plant(45, "small", name45, "May", "yes", "high", "30.c", "froot", "verygood Plant for show",
				33, price45, url45);
		Plant plant46 = new Plant(46, "small", name46, "feb", "No", "high", "30.c", "veg", "verygood Plant for show",
				66, price46, url46);
		Plant plant47 = new Plant(47, "small", name47, "July", "yes", "high", "30.c", "flower",
				"verygood Plant for show", 86, price47, url47);
		Plant plant48 = new Plant(48, "small", name48, "Dec", "No", "high", "30.c", "medicinal",
				"verygood Plant for show", 96, price48, url48);
		Plant plant49 = new Plant(49, "small", name49, "Jan", "No", "high", "30.c", "American",
				"verygood Plant for show", 26, price49, url49);
		Plant plant50 = new Plant(50, "small", name50, "Sept", "yes", "high", "30.c", "Fruit",
				"verygood Plant for show", 66, price50, url50);
		plantrepo.save(plant1);
		plantrepo.save(plant2);
		plantrepo.save(plant3);
		plantrepo.save(plant4);
		plantrepo.save(plant5);
		plantrepo.save(plant6);
		plantrepo.save(plant7);
		plantrepo.save(plant8);
		plantrepo.save(plant9);
		plantrepo.save(plant10);
		plantrepo.save(plant11);
		plantrepo.save(plant12);
		plantrepo.save(plant13);
		plantrepo.save(plant14);
		plantrepo.save(plant15);
		plantrepo.save(plant16);
		plantrepo.save(plant17);
		plantrepo.save(plant18);
		plantrepo.save(plant19);
		plantrepo.save(plant20);
		plantrepo.save(plant21);
		plantrepo.save(plant22);
		plantrepo.save(plant23);
		plantrepo.save(plant24);
		plantrepo.save(plant25);
		plantrepo.save(plant26);
		plantrepo.save(plant27);
		plantrepo.save(plant28);
		plantrepo.save(plant29);
		plantrepo.save(plant30);
		plantrepo.save(plant31);
		plantrepo.save(plant32);
		plantrepo.save(plant33);
		plantrepo.save(plant34);
		plantrepo.save(plant35);
		plantrepo.save(plant36);
		plantrepo.save(plant37);
		plantrepo.save(plant38);
		plantrepo.save(plant39);
		plantrepo.save(plant40);
		plantrepo.save(plant41);
		plantrepo.save(plant42);
		plantrepo.save(plant43);
		plantrepo.save(plant44);
		plantrepo.save(plant45);
		plantrepo.save(plant46);
		plantrepo.save(plant47);
		plantrepo.save(plant48);
		plantrepo.save(plant49);
		plantrepo.save(plant50);
	}
	
	public void addSeed(SeedRepository seedRepo) {
		Double seedsCost1=84.0;
		Double seedsCost2=99.0;
		Double seedsCost3=56.0;
		Double seedsCost4=90.0;
		Double seedsCost5=85.0;
		Double seedsCost6=89.0;
		Double seedsCost7=69.0;
		Double seedsCost8=105.0;
		Double seedsCost9=72.0;
		Double seedsCost10=86.0;
		String url1="https://user-images.githubusercontent.com/87129673/229087043-7c1caed0-8891-4a38-a4af-7b4195a36ff6.JPG";
		String url2="https://user-images.githubusercontent.com/87129673/229087051-3ccfbd30-7728-4481-9c1f-702b516b7aa6.JPG";
		String url3="https://user-images.githubusercontent.com/87129673/229087057-20eb8e85-5217-49d9-bc6b-bacd851db998.JPG";
		String url4="https://user-images.githubusercontent.com/87129673/229087062-7b8e2a89-f55e-4c76-917f-17be7ccb9059.JPG";
		String url5="https://user-images.githubusercontent.com/87129673/229087070-cc4740ad-860c-43e2-a265-7d226ceadcb1.JPG";
		String url6="https://user-images.githubusercontent.com/87129673/229087077-9c03c6fb-1d96-4a36-aa1e-0822da9b6ef4.JPG";
		String url7="https://user-images.githubusercontent.com/87129673/229087083-bf4e7dc4-3577-4fc2-8bd3-e658d90743ef.JPG";
		String url8="https://user-images.githubusercontent.com/87129673/229087087-02f5fe8b-c8d7-4c59-81e7-30f602ece8df.JPG";
		String url9="https://user-images.githubusercontent.com/87129673/229087093-5ef37726-1242-4958-836d-1e49857f8a81.JPG";
		String url10="https://user-images.githubusercontent.com/87129673/229087097-97fbcf67-e26a-428a-9361-bc2977073b8f.JPG";
		String url11="https://user-images.githubusercontent.com/87129673/229087098-7d266aac-2ce5-43b2-8470-5dd7cd9f11b3.JPG";
		String url12="https://user-images.githubusercontent.com/87129673/229087104-a01e98f1-9d17-4743-875e-324ed4450380.JPG";
		String url13="https://user-images.githubusercontent.com/87129673/229087110-91792923-2996-4e35-a468-929e2ceb581e.JPG";
		String url14="https://user-images.githubusercontent.com/87129673/229087113-548aac37-306e-46cf-854c-ae64ccdb60a6.JPG";
		String url15="https://user-images.githubusercontent.com/87129673/229087119-95e9c37d-1e54-4fc8-8f2b-476ccad8a9bd.JPG";
		String url16="https://user-images.githubusercontent.com/87129673/229087124-19d99e80-8630-4563-bc07-009af5ed9190.JPG";
		String url17="https://user-images.githubusercontent.com/87129673/229087125-573d070b-180f-4a82-ab2e-df5f9f6ba8f8.JPG";
		String url18="https://user-images.githubusercontent.com/87129673/229087132-3422b962-5c80-4b82-b624-9d3b0e6c5da7.JPG";
		String url19="https://user-images.githubusercontent.com/87129673/229087133-7b09abb5-985a-416b-b886-76c9113a26f8.JPG";
		String url20="https://user-images.githubusercontent.com/87129673/229087137-00ed4415-e4fc-4fbf-9b93-f75e7378f5a1.JPG";
		String url21="https://user-images.githubusercontent.com/87129673/229087141-8e0cbb6b-9263-4d90-92f1-3a9983bcbd0d.JPG";
		String url22="https://user-images.githubusercontent.com/87129673/229087144-c50c0d59-6cbe-4780-b1cc-4abcde06c5ca.JPG";
		String url23="https://user-images.githubusercontent.com/87129673/229087150-1e49319b-dd32-4d63-9359-71ac71616a81.JPG";
		String url24="https://user-images.githubusercontent.com/87129673/229087154-b55725ac-939e-4aa5-be1b-eec615dedf8e.JPG";
		String url25="https://user-images.githubusercontent.com/87129673/229087156-c5660471-bbfd-4d0b-81a8-1a6dac015564.JPG";
		String url26="https://user-images.githubusercontent.com/87129673/229087163-e53946a8-2a85-49cf-b67a-81f081d21f64.JPG";
		String url27="https://user-images.githubusercontent.com/87129673/229087164-fa18b6f7-b5cc-468d-aa54-9edd4f5a567e.JPG";
		String url28="https://user-images.githubusercontent.com/87129673/229087169-4c1edf70-13f8-4a67-8d59-1ac66fde79e5.JPG";
		String url29="https://user-images.githubusercontent.com/87129673/229087173-5621e335-7720-4f92-b555-50be78c70526.JPG";
		String url30="https://user-images.githubusercontent.com/87129673/229087175-cd577a4d-f12f-481a-9289-ab9301ebae20.JPG";
		String commonName1="500-mg-green-chilli-seeds";
		String commonName2="600-mg-tomato-seeds";
		String commonName3="1000-seeds-italian-basil-seeds";
		String commonName4="broccoli-seeds";
		String commonName5="celery-3500-seeds";
		String commonName6="cherry-tomatoes-seeds-yellow";
		String commonName7="cherry-tomato-seeds";
		String commonName8="chrysanthemum-mix-seeds";
		String commonName9="drumstick-seeds-moringa";
		String commonName10="kale-seeds";
		String commonName11="marigold-french-seeds";
		String commonName12="oregano-seeds";
		String commonName13="pak-choi-seed";
		String commonName14="portulaca-mix-seeds";
		String commonName15="red-capsicum-seeds";
		String commonName16="sunflower-sungold-seeds";
		String commonName17="thai-basil-1000-seeds";
		String commonName18="thyme-seeds";
		String commonName19="vinca-seeds";
		String commonName20="zinnia-lilliput-mix-seeds";
		String commonName21="arugula-seeds-rocket-leaves";
		String commonName22="1-2-gm-green-cucumber-seeds-long";
		String commonName23="1-5-gm-ipomoea-morning-glory-seeds";
		String commonName24="1-gm-aster-mix-seeds";
		String commonName25="1-gm-marigold-african-double-seeds";
		String commonName26="2-gm-brinjal-banarshi-giant-seeds";
		String commonName27="2-gm-cosmos-mix-seeds";
		String commonName28="6-gm-coriander-seeds";
		String commonName29="10-gm-okra-seeds-lady-finger";
		String commonName30="16-gm-spinach-seeds-palak";
		Seed seed1=new Seed(commonName1,"Jan","EveryDay","Easy","35degree","hybrid","bestQuality",200,seedsCost1,65,url1);
		Seed seed2=new Seed(commonName2,"feb","EveryDay","Easy","25degree","hybrid","bestQuality",200,seedsCost2,65,url2);
		Seed seed3=new Seed(commonName3,"March","EveryDay","Easy","50degree","hybrid","bestQuality",200,seedsCost3,65,url3);
		Seed seed4=new Seed(commonName4,"April","EveryDay","Easy","45degree","hybrid","bestQuality",200,seedsCost4,65,url4);
		Seed seed5=new Seed(commonName5,"May","EveryDay","Easy","65degree","hybrid","bestQuality",200,seedsCost5,65,url5);
		Seed seed6=new Seed(commonName6,"June","EveryDay","Easy","45degree","hybrid","bestQuality",200,seedsCost6,65,url6);
		Seed seed7=new Seed(commonName7,"July","EveryDay","Easy","56degree","hybrid","bestQuality",200,seedsCost7,65,url7);
		Seed seed8=new Seed(commonName8,"Aug","EveryDay","Easy","36degree","hybrid","bestQuality",200,seedsCost8,65,url8);
		Seed seed9=new Seed(commonName9,"Sept","EveryDay","Easy","535degree","hybrid","bestQuality",200,seedsCost9,65,url9);
		Seed seed10=new Seed(commonName10,"dec","EveryDay","Easy","95degree","hybrid","bestQuality",200,seedsCost10,65,url10);
		Seed seed11=new Seed(commonName11,"Jan","EveryDay","Easy","35degree","hybrid","bestQuality",200,seedsCost1,65,url1);
		Seed seed12=new Seed(commonName12,"feb","EveryDay","Easy","25degree","hybrid","bestQuality",200,seedsCost2,65,url12);
		Seed seed13=new Seed(commonName13,"March","EveryDay","Easy","50degree","hybrid","bestQuality",200,seedsCost3,65,url13);
		Seed seed14=new Seed(commonName14,"April","EveryDay","Easy","45degree","hybrid","bestQuality",200,seedsCost4,65,url14);
		Seed seed15=new Seed(commonName15,"May","EveryDay","Easy","65degree","hybrid","bestQuality",200,seedsCost5,65,url15);
		Seed seed16=new Seed(commonName16,"June","EveryDay","Easy","45degree","hybrid","bestQuality",200,seedsCost6,65,url16);
		Seed seed17=new Seed(commonName17,"July","EveryDay","Easy","56degree","hybrid","bestQuality",200,seedsCost7,65,url17);
		Seed seed18=new Seed(commonName18,"Aug","EveryDay","Easy","36degree","hybrid","bestQuality",200,seedsCost8,65,url18);
		Seed seed19=new Seed(commonName19,"Sept","EveryDay","Easy","535degree","hybrid","bestQuality",200,seedsCost9,65,url19);
		Seed seed20=new Seed(commonName20,"dec","EveryDay","Easy","95degree","hybrid","bestQuality",200,seedsCost10,65,url20);
		Seed seed21=new Seed(commonName21,"Jan","EveryDay","Easy","35degree","hybrid","bestQuality",200,seedsCost1,65,url21);
		Seed seed22=new Seed(commonName22,"feb","EveryDay","Easy","25degree","hybrid","bestQuality",200,seedsCost2,65,url22);
		Seed seed23=new Seed(commonName23,"March","EveryDay","Easy","50degree","hybrid","bestQuality",200,seedsCost3,65,url23);
		Seed seed24=new Seed(commonName24,"April","EveryDay","Easy","45degree","hybrid","bestQuality",200,seedsCost4,65,url24);
		Seed seed25=new Seed(commonName25,"May","EveryDay","Easy","65degree","hybrid","bestQuality",200,seedsCost5,65,url25);
		Seed seed26=new Seed(commonName26,"June","EveryDay","Easy","45degree","hybrid","bestQuality",200,seedsCost6,65,url26);
		Seed seed27=new Seed(commonName27,"July","EveryDay","Easy","56degree","hybrid","bestQuality",200,seedsCost7,65,url27);
		Seed seed28=new Seed(commonName28,"Aug","EveryDay","Easy","36degree","hybrid","bestQuality",200,seedsCost8,65,url28);
		Seed seed29=new Seed(commonName29,"Sept","EveryDay","Easy","535degree","hybrid","bestQuality",200,seedsCost9,65,url29);
		Seed seed30=new Seed(commonName30,"dec","EveryDay","Easy","95degree","hybrid","bestQuality",200,seedsCost10,65,url30);
		seedRepo.save(seed1);
		seedRepo.save(seed2);
		seedRepo.save(seed3);
		seedRepo.save(seed4);
		seedRepo.save(seed5);
		seedRepo.save(seed6);
		seedRepo.save(seed7);
        seedRepo.save(seed8);
		seedRepo.save(seed9);
		seedRepo.save(seed10);
		seedRepo.save(seed11);
		seedRepo.save(seed12);
		seedRepo.save(seed13);
		seedRepo.save(seed14);
        seedRepo.save(seed15);
		seedRepo.save(seed16);
		seedRepo.save(seed17);
		seedRepo.save(seed18);
		seedRepo.save(seed19);
		seedRepo.save(seed20);
		seedRepo.save(seed21);
        seedRepo.save(seed22);
		seedRepo.save(seed23);
		seedRepo.save(seed24);
		seedRepo.save(seed25);
		seedRepo.save(seed26);
		seedRepo.save(seed27);
		seedRepo.save(seed28);
        seedRepo.save(seed29);
		seedRepo.save(seed30);
		
	}
	public void addPlanter(PlanterRepository planterRepo) {
		
		Integer  holes1=1;
		Integer  holes2=2;
		Integer  holes3=1;
		Integer  holes4=6;
		Integer  holes5=3;
		Integer  holes6=4;
		Integer  holes7=4;
		Integer  holes8=5;
		Integer  holes9=2;
		Integer  holes10=3;
		

	
		String name1="reca-40-multicolour-window-planter-set-of";
		String name2="reusable-50-holes-seedling-tray-set-of";
		String name3="reusable-104-holes-seedling-tray-set";
		String name4="small-black-zuri-planter-ball-rib";
		String name5="small-gold-zuri-planter-ball-groove";
		String name6="small-light-grey-oslo-planter";
		String name7="7 5-inch-set-of-5-multi";
		String name8="AImagewithPlant";
		String name9="chatura-self-watering-pots-set-of";
		String name10="dove-with-plant";
		String name11="football-5-inch-yellow-with-plant";
		String name12="inch-set-of-six";
		String name13="lilac-stories-set-of-3-magenta";
		String name14="macrame-three-layer-hanger";
		String name15="macrame-two-layer-hange";
		String name16="multicolour-set-of";
		String name17="nature_s-hum1w";
		String name18="phoenix-12-inch-white-with-plant_1";
		String name19="pot_redone592";
		String name20="precious-horcrux-small-grey-with-plan";
		
		
		
		Integer   cost1=802;
		Integer  cost2=230;
		Integer  cost3=199;
		Integer  cost4=820;
		Integer  cost5=320;
		Integer  cost6=460;
		Integer  cost7=450;
		Integer  cost8=599;
		Integer  cost9=299;
		Integer  cost10=399;
		
		
		
		Integer  pheight1=8;
		Integer  pheight2=2;
		Integer  pheight3=1;
		Integer  pheight4=8;
		Integer  pheight5=3;
		Integer  pheight6=4;
		Integer  pheight7=4;
		Integer  pheight8=5;
		Integer  pheight9=2;
		Integer  pheight10=3;
		
		
		String url1="https://user-images.githubusercontent.com/87129673/229305299-e7be09ec-e3c0-4f89-ac6c-adbd6a23dcc3.JPG";
		String url2="https://user-images.githubusercontent.com/87129673/229305302-ad375c47-714e-4815-911a-fed562e276f5.JPG";
		String url3="https://user-images.githubusercontent.com/87129673/229305305-0bcf9d03-79b4-4263-86b2-9ef611c756e4.JPG";
		String url4="https://user-images.githubusercontent.com/87129673/229305307-b41cb3db-48e2-4220-91e8-30581099d9a1.JPG";
		String url5="https://user-images.githubusercontent.com/87129673/229305308-af632585-90dd-49d7-9b2f-6ca8bee94258.JPG";
		String url6="https://user-images.githubusercontent.com/87129673/229305311-50674a54-39d0-430a-a025-ac7d6779388b.JPG";
		String url7="https://user-images.githubusercontent.com/87129673/229305313-2cf2c345-9058-4c46-8609-a2fc37db064c.JPG";
		String url8="https://user-images.githubusercontent.com/87129673/229305320-db6de6a1-01e3-4db2-8296-58ca7aa0d376.JPG";
		String url9="https://user-images.githubusercontent.com/87129673/229305321-527c152d-c572-4cb2-8d4b-6319fe027d73.JPG";
		String url10="https://user-images.githubusercontent.com/87129673/229305324-20c19517-08a6-4f28-b324-b8a20db8d2ad.JPG";
		String url11="https://user-images.githubusercontent.com/87129673/229305327-d2519eee-7dbe-4d37-ad10-a278c2d968a2.JPG";
		String url12="https://user-images.githubusercontent.com/87129673/229305330-9afeb374-16d7-48f5-b3bd-5cf9e303e2c3.JPG";
		String url13="https://user-images.githubusercontent.com/87129673/229305334-c0bfb853-08bd-43e4-b702-401d3492670d.JPG";
		String ur114="https://user-images.githubusercontent.com/87129673/229305337-e34aeddf-92b2-4091-b555-bd7c27f7bb82.JPG";
		String url15="https://user-images.githubusercontent.com/87129673/229305339-08f0f10c-26da-46d8-a347-5db5ec830474.JPG";
		String url16="https://user-images.githubusercontent.com/87129673/229305341-eaba816a-2057-40ad-ba45-21e69ab35285.JPG";
		String url17="https://user-images.githubusercontent.com/87129673/229305343-901befaa-b755-4de1-8116-78afdb9c3521.JPG";
		String url18="https://user-images.githubusercontent.com/87129673/229305345-c5a530ae-0a13-4365-8003-eb83502fd625.JPG";
		String url19="https://user-images.githubusercontent.com/87129673/229305347-deb47c29-9be1-405b-ad3a-11dfde2f70bc.JPG";
		String url20="https://user-images.githubusercontent.com/87129673/229305349-b30fd5af-78db-49eb-b82d-e0b52cf5c167.JPG";
		Integer  stock1=80;
		Integer  stock2=23;
		Integer  stock3=19;
		Integer  stock4=60;
		Integer  stock5=30;
		Integer  stock6=40;
		Integer  stock7=40;
		Integer  stock8=59;
		Integer  stock9=29;
		Integer  stock10=32;
		
		Integer  capacity1=80;
		Integer  capacity2=23;
		Integer  capacity3=19;
		Integer  capacity4=60;
		Integer  capacity5=30;
		Integer  capacity6=40;
		Integer  capacity7=40;
		Integer  capacity8=59;
		Integer  capacity9=29;
		Integer  capacity10=32;

		Planter planter1=new Planter(pheight1,capacity1,holes1,"red","round",stock1,cost1,"url1");
		Planter planter2=new Planter(pheight2,capacity1,holes2,"green","round",stock2,cost2,"url2");
		Planter planter3=new Planter(pheight3,capacity2,holes3,"red","round",stock3,cost3,"url3");
		Planter planter4=new Planter(pheight4,capacity3,holes4,"red","round",stock4,cost4,"url4");
		Planter planter5=new Planter(pheight5,capacity4,holes5,"red","round",stock5,cost5,"url5");
		Planter planter6=new Planter(pheight6,capacity5,holes6,"red","round",stock6,cost6,"url6");
		Planter planter7=new Planter(pheight7,capacity6,holes7,"red","round",stock7,cost7,"url7");
		Planter planter8=new Planter(pheight8,capacity7,holes8,"red","round",stock8,cost8,"url8");
		Planter planter9=new Planter(pheight9,capacity8,holes9,"red","round",stock9,cost9,"url9");
		Planter planter10=new Planter(pheight10,capacity9,holes10,"red","round",stock10,cost10,"url10");
		Planter planter11=new Planter(pheight1,capacity1,holes1,"red","round",stock1,cost1,"url11");
		Planter planter12=new Planter(pheight2,capacity1,holes2,"green","round",stock2,cost2,"url12");
		Planter planter13=new Planter(pheight3,capacity2,holes3,"red","round",stock3,cost3,"url13");
		Planter planter14=new Planter(pheight4,capacity3,holes4,"red","round",stock4,cost4,"url14");
		Planter planter15=new Planter(pheight5,capacity4,holes5,"red","round",stock5,cost5,"url15");
		Planter planter16=new Planter(pheight6,capacity5,holes6,"red","round",stock6,cost6,"url16");
		Planter planter17=new Planter(pheight7,capacity6,holes7,"red","round",stock7,cost7,"url17");
		Planter planter18=new Planter(pheight8,capacity7,holes8,"red","round",stock8,cost8,"url18");
		Planter planter19=new Planter(pheight9,capacity8,holes9,"red","round",stock9,cost9,"url19");
		Planter planter20=new Planter(pheight10,capacity9,holes10,"red","round",stock10,cost10,"url20");
        planterRepo.save( planter1);
		planterRepo.save( planter2);
		planterRepo.save( planter3);
		planterRepo.save( planter4);
		planterRepo.save( planter5);
		planterRepo.save( planter6);
		planterRepo.save( planter7);
        planterRepo.save( planter8);
		planterRepo.save( planter9);
		planterRepo.save( planter10);
		planterRepo.save( planter11);
		planterRepo.save( planter12);
		planterRepo.save( planter13);
		planterRepo.save( planter14);
        planterRepo.save( planter15);
		planterRepo.save( planter16);
		planterRepo.save( planter17);
		planterRepo.save( planter18);
		planterRepo.save( planter19);
		planterRepo.save( planter20);
		
	}

}
