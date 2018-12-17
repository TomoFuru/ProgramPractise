
#枠作成
datetimeframe<-function(x,y,z){
  datetime<-x %>% 
    dplyr::mutate(hour=hour(time),year=year(time),month=month(time),day=day(time)) %>%
    dplyr::group_by(year,month,day,hour,appcat.x) %>% 
    dplyr::select(year,month,day,hour) %>% 
    dplyr::summarise()
  mat<-matrix(0, nrow=nrow(datetime), ncol=1)
  colnames(mat) <- "n" 
  datetime<-cbind(data.frame(datetime),mat)
  datetime<-merge(datetime,data.frame(z$monitor),by=NULL)
  colnames(datetime)<-c("year","month","day","hour","appcat","n","monitor")

#枠と結合
y<-left_join(datetime,y,by=c("monitor","year","month","day","hour"))
#0補完
y[is.na(y)] <- 0

##ここにループをやき

#実際のデータにする

y<-mutate(y,n=n.x+n.y) %>% 
  select(monitor,year,month,day,hour,n,appcat.x)
#枠削除
rm(datetime)

#データの持たせ方変更(転置)
#y<-y %>% tidyr::spread(key = monitor, value = n)

return(y)
}

appdata_201604_06_time_monitor<-datetimeframe(appdata_201604_06,appdata_201604_06_time_monitor,appdata_201604_06_times)



datetime<-appdata_201604_06 %>% 
    dplyr::mutate(hour=hour(time),year=year(time),month=month(time),day=day(time)) %>%
    dplyr::group_by(year,month,day,hour) %>% 
    dplyr::select(year,month,day,hour) %>% 
    dplyr::summarise()
 datetime<-merge(datetime,data.frame(appdata_201604_06_times$monitor),by=NULL)
  colnames(datetime)<-c("year","month","day","hour","appcat.x","n","monitor")



####
datetime<-appdata_201604_06 %>% 
    dplyr::mutate(hour=hour(time),year=year(time),month=month(time),day=day(time)) %>%
    dplyr::group_by(year,month,day,hour,appcat.x) %>% 
    dplyr::select(year,month,day,hour) %>% 
    dplyr::summarise()
datetime<-cbind(data.frame(datetime),mat)
####
 datetime<-merge(datetime,data.frame(appdata_201604_06_account$monitor),by=NULL)
##ここがおかしい
datetime<-merge(datetime,data.frame(appdata_201604_06_times$monitor[50]),by=NULL)

datetime<-merge(datetime,appdata_201604_06_times,by=appcat.x)
appdata_201604_06_time_monitor<-left_join(datetime,appdata_201604_06_times,by=appcat.x)

y<-left_join(datetime,appdata_201604_06_time_monitor1,by=c("monitor","year","month","day","hour","appcat.x"))

###関数の中に入れる
y[is.na(y)] <- 0
class <- function(x){ 
for (i in 1:nrow(x)){
if (x[i,3] == "ツール類"){
 x[i,1]<-1
} else if(x[i,3]== "ゲーム"){
 x[i,1] <- 3
} else x[i,1]<- 2
}
x
}
y[is.na(y[,8])] <-"a"
appdata_201604_06_time_monitor <-dplyr::filter(appdata_201604_06_time_monitor,appcat==appcat.x)
y[is.na(y[,8])] <-"a"

y<-mutate(y,n=n.x+n.y) %>% 
  select(monitor,year,month,day,hour,n,appcat.x)

y3<-y %>% tidyr::spread(key = monitor,appcat.x value = n)


y1 <-  dplyr::filter(y,appcat==c("ツール類"))
y2 <-  dplyr::filter(y,appcat.x==c("ソーシャルネットワーキング"))
y3 <-  dplyr::filter(y,appcat.x==c("ゲーム"))
"ソーシャルネットワーキング"
mat1<-matrix("ツール類", nrow=nrow(y4), ncol=1)
  colnames(mat) <- "ツール類" 

mat3<-matrix(row(y1), nrow=nrow(y1), ncol=1)
  colnames(mat3) <- "Time" 
  
#####これが必要
   y4 <- y1 %>% group_by(monitor) %>%  #id毎にグループ化
  mutate(Time = row_number())
 y2 <- y2 %>% group_by(monitor) %>%  #id毎にグループ化
  mutate(Time = row_number()) 
 y3 <- y3 %>% group_by(monitor) %>%  #id毎にグループ化
  mutate(Time = row_number())


y7<-cbind(y4,mat3)
y8<-cbind(y5,mat3)
y9<-cbind(y6,mat3)
  datetime<-merge(datetime,data.frame(z$monitor),by=NULL)

dplyr::mutate(hour=hour(time),year=year(time),month=month(time),day=day(time)) y6 %>%

##通し番号
    dplyr::mutate(num=rownumber)
 mat1<-matrix(4, nrow=nrow(datetime), ncol=1)
colnames(mat1) <- "month" 
mat2<-matrix(5, nrow=nrow(datetime), ncol=1)
colnames(mat2) <- "month" 

mat3<-matrix(6, nrow=nrow(datetime), ncol=1)
colnames(mat3) <- "month" 


y6<-y6 %>% tidyr::spread(key = "Time", value = n)
y4 <- y4 %>% select("monitor","Time","n","appcat.x")
y2 <- y2 %>% select("monitor","Time","n","appcat.x")
y3 <- y3 %>% select("monitor","Time","n","appcat.x")
y9 <- y9 %>% select("monitor","Time","n","appcat.x")

y4<-y4 %>% tidyr::spread(key = "Time", value = n)
y2<-y2 %>% tidyr::spread(key = "Time", value = n)
y3<-y3 %>% tidyr::spread(key = "Time", value = n)
y9<-y9 %>% tidyr::spread(key = "Time", value = n)

y1 <- y1 %>% group_by(monitor)

mat<-matrix(0, nrow=nrow(y8), ncol=1)
  colnames(mat) <- "class" 

