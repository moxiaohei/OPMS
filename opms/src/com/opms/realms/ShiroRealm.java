package com.opms.realms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opms.entity.PmsPermissions;
import com.opms.entity.PmsUsers;
import com.opms.service.OrganizationService;


@Controller
public class ShiroRealm extends AuthorizingRealm{
	@Autowired
	private OrganizationService organizationservice;
	//��֤
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		//1. �� AuthenticationToken ת��Ϊ UsernamePasswordToken ǿת
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		//2. �� UsernamePasswordToken ������ȡ username
		String username= upToken.getUsername();
		//3. �������ݿ�ķ���, �����ݿ��в�ѯ username ��Ӧ���û���¼
		PmsUsers user=organizationservice.getPmsUsersByUsername(username);
		//4. ���û�������, ������׳� UnknownAccountException �쳣
		if(user==null){
			throw new UnknownAccountException("�û�������!");
		}
		//�����û���������ֵ
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		SimpleAuthenticationInfo info = null; //new SimpleAuthenticationInfo(principal, credentials, realmName);
		info = new SimpleAuthenticationInfo(user, user.getPassword(), credentialsSalt,getName());
		return info;
	}

	//��Ȩ
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		//1. �� PrincipalCollection ������ȡ��¼�û�����Ϣ
		PmsUsers principal = (PmsUsers) principals.getPrimaryPrincipal();
		List<PmsPermissions> list=organizationservice.listPmsPermissionsEname(principal.getUserid());
		Set<String> roles = new HashSet<>();
		if(list!=null){
		for (PmsPermissions pmsPermissions : list) {
			roles.add(pmsPermissions.getEname());
		}
		}
		
		//3. ���� SimpleAuthorizationInfo, �������� reles ����.
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		
		//4. ���� SimpleAuthorizationInfo ����. 
		return info;
	}

	public static void main(String[] args) {
		
	}

}
