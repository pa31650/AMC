package com.orasi.core.by.mobile;
/*
Copyright 2007-2011 Selenium committers

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */


import java.io.Serializable;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByXPath;

import com.orasi.core.Beta;
import com.orasi.core.by.mobile.internal.ByMobileResourceId;
import com.orasi.core.by.mobile.internal.ByMobileHelper;

/**
 * Mechanism used to locate elements within a document. In order to create your own locating
 * mechanisms, it is possible to subclass this class and override the protected methods as required,
 * though it is expected that that all subclasses rely on the basic finding mechanisms provided
 * through static methods of this class:
 * 
 * <code>
 * public WebElement findElement(WebDriver driver) {
 *     WebElement element = driver.findElement(By.id(getSelector()));
 *     if (element == null)
 *       element = driver.findElement(By.name(getSelector());
 *     return element;
 * }
 * </code>
 */
public abstract class ByMobile {

  /**
   * @param ngRepeater The value of the "buttonText" attribute to search for
   * @return a By which locates elements by the value of the "buttonText" attribute.
   */
  public static ByMobile resourceId(final String buttonText) {
    if (buttonText == null)
      throw new IllegalArgumentException(
          "Cannot find elements when buttonText text is null.");

    return new ByMobileResourceId(buttonText);
  }
  
  /**
   * Find a single element. Override this method if necessary.
   * 
   * @param context A context to use to find the element
   * @return The WebElement that matches the selector
   */
  public WebElement findElement(SearchContext context) {
    List<WebElement> allElements = findElements(context);
    if (allElements == null || allElements.isEmpty())
      throw new NoSuchElementException("Cannot locate an element using "
          + toString());
    return allElements.get(0);
  }

  /**
   * Find many elements.
   * 
   * @param context A context to use to find the element
   * @return A list of WebElements matching the selector
   */
  public abstract List<WebElement> findElements(SearchContext context);

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    ByMobile byNG = (ByMobile) o;

    return toString().equals(byNG.toString());
  }

  @Override
  public int hashCode() {
    return toString().hashCode();
  }

  @Override
  public String toString() {
    // A stub to prevent endless recursion in hashCode()
    return "[unknown locator]";
  }

  public static class ByMobileResourceId extends ByMobile implements Serializable {

    private static final long serialVersionUID = 376317282960469555L;

    private final String name;

    public ByMobileResourceId(String name) {
      this.name = name;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
      if (context instanceof FindsByMobileResourceId)
        return ((FindsByMobileResourceId) context).findElementsByMobileResourceId(name);
      return ((FindsByXPath) context).findElementsByXPath(".//*[@name = '" + name + "']");
    }

    @Override
    public WebElement findElement(SearchContext context) {
      if (context instanceof FindsByMobileResourceId)
        return ((FindsByMobileResourceId) context).findElementByMobileResourceId(name);
      return (WebElement) ((FindsByXPath) context).findElementsByXPath(".//*[@name = '"
          + name + "']");
    }

    @Override
    public String toString() {
      return name;
    }
  }
}