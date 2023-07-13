// IPPO Assignment 1, Version 20.3, 25/10/2021
package ippo.assignment1.proxy;

import ippo.assignment1.library.Picture;
import ippo.assignment1.library.service.Service;
import ippo.assignment1.library.service.ServiceFromProperties;
import ippo.assignment1.library.utils.HashMap;

import java.util.Objects;

/**
 * A skeleton cache proxy service for the PictureViewer application.
 * The skeleton does no implement any caching!
 *
 * @author Yingfan Xu;
 * @version Version 21, 25/10/2021
 */
public class CacheProxy implements Service {
	HashMap<Key,Picture> cache = new HashMap<>();
	private Service baseService = null;

	/**
	 * Return a textual name for the service.
	 *
	 * @return the name of the base service
	 */
	public String serviceName() {
		return baseService.serviceName();
	}

	/**
	 * Create a proxy service based on the service specified in the
	 * <code>proxy.cache.service</code> resource.
	 */
	public CacheProxy() {
		baseService = new ServiceFromProperties("proxy.cache.service");
	}

	/**
	 * Create a proxy service based on the specified service.
	 *
	 * @param baseService the base service
	 */
	public CacheProxy(Service baseService) {
		this.baseService = baseService;
	}

	/**
	 * Return a picture from the base service.
	 *
	 * @param subject the free-text subject string
	 * @param index the index of the matching picture to return
	 * @return the requested picture
	 */
	public Picture getPicture(String subject, int index) {
		Key cacheKey = new Key(subject, index);
		if(cache.containsKey(cacheKey)){
			return cache.get(cacheKey);
		}
		else{
			final Picture picture = baseService.getPicture(subject, index);
			cache.put(cacheKey,picture);
			return picture;
		}


	}
}

class Key{
	public String subject;
	public Integer index;

	public Key(String subject, Integer index) {
		this.subject = subject;
		this.index = index;
	}

	@Override
	public String toString() {
		return "Key{" +
				"subject='" + subject + '\'' +
				", index=" + index +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Key cacheKey = (Key) o;
		return subject.equals(cacheKey.subject) && index.equals(cacheKey.index);
	}

	@Override
	public int hashCode() {
		return Objects.hash(subject, index);
	}
}
