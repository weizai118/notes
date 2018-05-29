----------------------------
ribbon						|
----------------------------
	# Spring Cloud Ribbon �ǻ���Netflix Ribbonʵ�ֵ�һ��'�ͻ���,���ؾ���'����
	# Ribbon��netflix�����Ŀ�Դ��Ŀ,��Ҫ�ṩ�ͻ��˵��������ؾ����㷨
	# LB(Load Balance)��΢������߷ֲ�ʽ��Ⱥ�о����õ�һ��Ӧ��
	# �����ĸ��ؾ���Nginx,LVS,Ӳ��F5
	
	# ���ؾ��������
		* Ӳ��LB
			* F5֮���,����
		* ������LB
			* ��LB�߼����ɵ����ѷ�,���ѷ���ע�����Ļ�ȡ�����ַ,�ٴӵ�ַ��ѡ��һ�����е���
	
	# ribbon�ڹ���ʱ��Ϊ����
		1,��ѡ��EurekaServer,��ѡ��ͬһ�����ڸ��ؽ��ٵ�EurekaServer
		2,�����û�ָ���Ĳ���,��Serverȡ�������ṩ��(���)�ĵ�ַ��Ϣ�л�ȡһ������Զ�̵���
	
	# ribbon�ṩ�˶��ֲ���:��ѯ,���,������Ӧʱ���Ȩ

	# Ĭ���㷨��-��ѯ


----------------------------
����						|
----------------------------
	# ����
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-ribbon</artifactId>
			<version>1.4.4.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-eureka</artifactId>
			<version>1.4.4.RELEASE</version>
		</dependency>
	
	# �������ؾ���
		@Configuration
		public class RestTemplateConfig{

			@Bean
			@LoadBalance
			public RestTemplate restTemplate(){
				return new RestTemplate();
			}
		}

		* �� RestTemplate ע��Iocʱ,���� @LoadBalance ע��
		

		

	